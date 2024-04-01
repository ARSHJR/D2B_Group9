package Model.Songs;

import Utils.Displayable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import View.song.AddSongsConfirmationFrame;
import View.song.DeleteSongsConfirmationFrame;
import View.song.EditSongsConfirmationFrame;
import com.fasterxml.jackson.databind.JsonNode; //jackson is an api to read/write to JSON files (I think)
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageSongs extends FileHandlingSongs implements Displayable {
    /*
    This class basically acts as the intermediate between the database (json file) and our actual program (to add artists and songs).
    The purpose of this class is to collect all the data of various artists and songs from our json file
     */
    ArrayList<Songs> songs = new ArrayList<Songs>();

    ObjectMapper objectMapper = new ObjectMapper();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    final private String filepath= "D:\\College\\1st Year\\Sem 2\\Java\\MiniProject\\PCC_MiniProject\\src\\Model\\Songs\\Songs.json";

    public ManageSongs() {
        readSongsJsonFile(filepath);
    }
    @Override
    public ArrayList<Songs> readSongsJsonFile(String file_path)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {

            JsonNode rootnode = mapper.readTree(new File(file_path));
            // Iterate through JSON array
            if (rootnode.isArray()) {
                songs.clear();
                for (JsonNode node : rootnode) {
                    int s_id = node.get("song_id").asInt();
                    String language = node.get("media_Lang").asText();
                    String s_name = node.get("song_name").asText();
                    double s_duration = node.get("song_duration").asDouble();
                    double media_rating = node.get("media_Rating").asDouble();
                    String media_date = node.get("media_Date").asText();
                    Songs song = new Songs(s_id, language, s_name, s_duration, media_rating, media_date);
                    songs.add(song);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
    public void writeSongsJsonFile(String file_path, ArrayList<Songs> songs) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), songs);
    }
    public void setSongsTable(ArrayList<Songs> songs) {
        this.songs = songs;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("Name");
        headers.add("Language");
        headers.add("Song duration");
        headers.add("Media rating");
        headers.add("Media date");

        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> song_details = new ArrayList<>();

        song_details.add(String.valueOf(songs.get(line).getSong_id()));
        song_details.add(songs.get(line).getSong_name());
        song_details.add(songs.get(line).getMedia_Lang());
        song_details.add(String.valueOf(songs.get(line).getSong_duration()));
        song_details.add(String.valueOf(songs.get(line).getMedia_Rating()));
        song_details.add(songs.get(line).getMedia_Date());

        return song_details;
    }
    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> songs_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            songs_subset.add(getLine(i));
        }
        return songs_subset;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Songs> getTable() {
        return songs;
    }

    //CRUD:

    public void addNewSong(int s_id, String language, String s_name, double s_duration, double media_rating, String media_date) throws IOException {
        readSongsJsonFile(filepath);
        Songs temp_s = new Songs(s_id, language, s_name, s_duration, media_rating, media_date);
        songs.add(temp_s);
        writeSongsJsonFile(filepath, songs);

        AddSongsConfirmationFrame confirmationPopUp = new AddSongsConfirmationFrame();
    }

    public void editSong(int edit_s_id, int s_id, String language, String s_name, double s_duration, double media_rating, String media_date) throws IOException {
        readSongsJsonFile(filepath);
        songs.get(edit_s_id).setSong_id(s_id);
        songs.get(edit_s_id).setMedia_Lang(language);
        songs.get(edit_s_id).setSong_name(s_name);
        songs.get(edit_s_id).setSong_duration(s_duration);
        songs.get(edit_s_id).setMedia_Rating(media_rating);
        songs.get(edit_s_id).setMedia_Date(media_date);
        writeSongsJsonFile(filepath, songs);

        EditSongsConfirmationFrame confirmationPopUp = new EditSongsConfirmationFrame();
    }

    public int deleteSong(int delete_s_id) throws IOException {
        readSongsJsonFile(filepath);
        songs.remove(delete_s_id);
        int s_id = songs.get(delete_s_id).getSong_id();
        writeSongsJsonFile(filepath, songs);

        DeleteSongsConfirmationFrame confirmationPopUp = new DeleteSongsConfirmationFrame();
        return s_id;
    }
}
