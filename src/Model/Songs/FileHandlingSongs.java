package Model.Songs;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingSongs {
    protected abstract ArrayList<Songs> readSongsJsonFile(String file_path);
    protected abstract void writeSongsJsonFile(String file_path, ArrayList<Songs> songs) throws IOException;
}
