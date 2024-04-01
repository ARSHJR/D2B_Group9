package Model.Artists;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingArtists {
    protected abstract ArrayList<Artists> readArtistsJSON_File (String file_path); //protected therefore function can only be called in the class in which this class is inherited
    protected abstract void writeArtistsJSON_File(String file_path, ArrayList<Artists> artists) throws IOException;
}
