package Model.Artists;
import Utils.Displayable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import View.artist.AddArtistsConfirmationFrame;
import View.artist.DeleteArtistsConfirmationFrame;
import View.artist.EditArtistsConfirmationFrame;
import com.fasterxml.jackson.databind.JsonNode; //jackson is an api to read/write to JSON files (I think)
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManageArtists extends FileHandlingArtists implements Displayable {
    /*
    This class basically acts as the intermediate between the database (json file) and our actual program (to add artists and songs).
    The purpose of this class is to collect all the data of various artists and songs from our json file
     */

    ArrayList<Artists> artists = new ArrayList<Artists>();
    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    final private String filepath = "D:\\College\\1st Year\\Sem 2\\Java\\MiniProject\\PCC_MiniProject\\src\\Model\\Artists\\Artists.json";

    public ManageArtists() {
        readArtistsJSON_File(filepath);
    }

    @Override
    public ArrayList<Artists> readArtistsJSON_File(String file_path) {
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                artists.clear();
                for (JsonNode node : rootNode) {
                    int A_id = node.get("a_id").asInt();
                    String fname = node.get("f_name").asText();
                    String lname = node.get("l_name").asText();
                    String email = node.get("email").asText();
                    int networth = node.get("netWorth").asInt();
                    String A_Genre = node.get("a_Genre").asText();
                    String A_Label = node.get("a_Label").asText();
                    artists.add(new Artists(A_id, fname, lname, email, networth, A_Genre, A_Label));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artists;
    }

    @Override
    public void writeArtistsJSON_File(String file_path, ArrayList<Artists> artists) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), artists);
    }

    public void setArtistsTable(ArrayList<Artists> Artists) {
        this.artists = artists;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("First Name");
        headers.add("Last Email");
        headers.add("Email");
        headers.add("Net Worth");
        headers.add("Genre");
        headers.add("Label");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> artists_details = new ArrayList<String>();

        artists_details.add(String.valueOf(artists.get(line).getA_id()));
        artists_details.add(artists.get(line).getF_name());
        artists_details.add(artists.get(line).getL_name());
        artists_details.add(artists.get(line).getEmail());
        artists_details.add((String.valueOf(artists.get(line).getNetWorth())));
        artists_details.add(artists.get(line).getA_Genre());
        artists_details.add(String.valueOf(artists.get(line).getA_Label()));

        return artists_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> artists_subset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            artists_subset.add(getLine(i));
        }
        return artists_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
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

    public ArrayList<Artists> getTable() {
        return artists;
    }

    //CRUD:

    public void addNewArtists(int A_id, String f_name, String l_name, String email, int networth, String genre, String label) {
        readArtistsJSON_File(filepath);
        artists.add(new Artists(A_id, f_name, l_name, email, networth, genre, label));
        try {
            writeArtistsJSON_File(filepath, artists);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AddArtistsConfirmationFrame confirmationPopUp = new AddArtistsConfirmationFrame();
    }

    public void editArtists(int edit_artist_idx, int A_id, String f_name, String l_name, String email, int networth, String genre, String label) {
        readArtistsJSON_File(filepath);
        artists.get(edit_artist_idx).setA_id(A_id);
        artists.get(edit_artist_idx).setF_name(f_name);
        artists.get(edit_artist_idx).setL_name(l_name);
        artists.get(edit_artist_idx).setEmail(email);
        artists.get(edit_artist_idx).setNetWorth(networth);
        artists.get(edit_artist_idx).setA_Genre(genre);
        artists.get(edit_artist_idx).setA_Label(label);

        try {
            writeArtistsJSON_File(filepath, artists);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EditArtistsConfirmationFrame confirmationPopUp = new EditArtistsConfirmationFrame();
    }

    public int deleteArtists(int delete_artist_idx) throws IOException {
        readArtistsJSON_File(filepath);
        artists.remove(delete_artist_idx);
        int t_id = artists.get(delete_artist_idx).getA_id();
        writeArtistsJSON_File(filepath, artists);
        DeleteArtistsConfirmationFrame confirmationPopUp = new DeleteArtistsConfirmationFrame();
        return t_id;
    }
}
