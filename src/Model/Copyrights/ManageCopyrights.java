package Model.Copyrights;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Songs.*;
import Model.Songs.ManageSongs;
import Utils.Displayable;
import Model.Artists.*;
import Model.Artists.ManageArtists;
import View.copyright.AddCopyrightConfirmationFrame;
import View.copyright.DeleteCopyrightConfirmationFrame;
import View.copyright.DeleteCopyrightPanel;
import View.copyright.EditCopyrightConfirmationFrame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageCopyrights extends FileHandlingCopyrights implements Displayable {
    ArrayList<Songs> songs = new ArrayList<Songs>();
    ArrayList<Artists> artists = new ArrayList<Artists>();
    ArrayList<Copyrights> copyrightsArrayList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    final private String filepath = "D:\\College\\1st Year\\Sem 2\\Java\\MiniProject\\PCC_MiniProject\\src\\Model\\Copyrights\\Copyrights.json";

    public ManageCopyrights() {
        ManageArtists ma1 = new ManageArtists();
        artists = ma1.getTable();
        ManageSongs ms1 = new ManageSongs();
        songs = ms1.getTable();
        readCopyrightsJSONfile(filepath);
    }

    @Override
    public ArrayList<Copyrights> readCopyrightsJSONfile(String file_path) {
        copyrightsArrayList.removeAll(copyrightsArrayList);

        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            // Iterate through JSON array
            if (rootNode.isArray()) {
                copyrightsArrayList.clear();
                for (JsonNode node : rootNode) {
                    int copyright_id = node.get("copyright_id").asInt();
                    int songId = node.get("songId").asInt();
                    int artistId = node.get("artistId").asInt();
                    String record_lable = node.get("record_label").asText();

                    Songs songs1 = null;
                    Artists artists1 = null;

                    for(int i = 0; i < songs.size(); i++)
                    {
                        if(songId == songs.get(i).getSong_id())
                        {
                            songs1 = songs.get(i);
                        }
                    }

                    for(int i = 0; i < artists.size(); i++)
                    {
                        if(artistId == artists.get(i).getA_id())
                        {
                            artists1 = artists.get(i);
                        }
                    }

                    Copyrights c_temp = new Copyrights(copyright_id, songs1, artists1, record_lable);
                    copyrightsArrayList.add(c_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return copyrightsArrayList;
    }

    @Override
    public void writeCopyrightsJSONfile(String file_path, ArrayList<Copyrights> copyrights) throws IOException {

        //ArrayList<ArrayList<String>> copyright_add = new ArrayList<ArrayList<String>>();
        ArrayList<HashMap<String, Object>> copyright_add = new ArrayList<>();


        for(int i = 0; i < copyrights.size(); i++)
        {
            HashMap<String, Object> data = new HashMap<>();
            data.put("copyright_id", copyrights.get(i).getCopyright_id());
            data.put("songId", copyrights.get(i).getSongId().getSong_id());
            data.put("artistId", copyrights.get(i).getArtistId().getA_id());
            data.put("record_label", copyrights.get(i).getRecord_lable());

            copyright_add.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), copyright_add);
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> copyright_details = new ArrayList<>();

        copyright_details.add(String.valueOf(copyrightsArrayList.get(line).getCopyright_id()));
        copyright_details.add(String.valueOf(copyrightsArrayList.get(line).get_song_id()));
        copyright_details.add(String.valueOf(copyrightsArrayList.get(line).get_artist_id()));
        copyright_details.add(copyrightsArrayList.get(line).getRecord_lable());

        return copyright_details;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Copyright_id");
        headers.add("Song_id");
        headers.add("Artist_id");
        headers.add("Record lable");

        return headers;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> copyyright_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            copyyright_subset.add(getLine(i));
        }
        return copyyright_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return this.firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return 0;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(this.firstLineIndex + this.linesBeingDisplayed - 1);
        return this.lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return this.linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Copyrights> getTable() {
        readCopyrightsJSONfile(filepath);
        return copyrightsArrayList;
    }

    public void addNewCopyright(int copyid, int songId, int artistId, String record_lable) throws IOException{
        readCopyrightsJSONfile(filepath);
        Copyrights temp_c = new Copyrights(copyid, songs.get(songId), artists.get(artistId), record_lable);
        copyrightsArrayList.add(temp_c);
        writeCopyrightsJSONfile(filepath, copyrightsArrayList);

        AddCopyrightConfirmationFrame confirmationPopUp = new AddCopyrightConfirmationFrame();
    }

    public void editCopyright(int edit_copyright_id, int copyright_id, int songId, int artistId, String record_lable) throws IOException {
        readCopyrightsJSONfile(filepath);
        copyrightsArrayList.get(edit_copyright_id).setCopyright_id(copyright_id);
        copyrightsArrayList.get(edit_copyright_id).setRecord_lable(record_lable);
        copyrightsArrayList.get(edit_copyright_id).setSongId(songs.get(songId));
        copyrightsArrayList.get(edit_copyright_id).setArtistId(artists.get(artistId));
        writeCopyrightsJSONfile(filepath, copyrightsArrayList);

        EditCopyrightConfirmationFrame confirmationPopUp = new EditCopyrightConfirmationFrame();
    }
    public void deleteCopyright(int delete_copyright_id) throws IOException {
        readCopyrightsJSONfile(filepath);
        copyrightsArrayList.remove(delete_copyright_id);
        writeCopyrightsJSONfile(filepath, copyrightsArrayList);

        DeleteCopyrightConfirmationFrame confirmationPopUp = new DeleteCopyrightConfirmationFrame();
    }
}
