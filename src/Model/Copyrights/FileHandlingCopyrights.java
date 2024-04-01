package Model.Copyrights;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingCopyrights {
    protected abstract ArrayList<Copyrights> readCopyrightsJSONfile(String file_path);
    protected abstract void writeCopyrightsJSONfile(String file_path, ArrayList<Copyrights> copyrights) throws IOException;
}
