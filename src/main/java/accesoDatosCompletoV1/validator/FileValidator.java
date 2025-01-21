package accesoDatosCompletoV1.validator;

import accesoDatosCompletoV1.input.ReadCSV;
import accesoDatosCompletoV1.input.ReadJSON;

import java.io.File;

public class FileValidator {

    public static boolean fileExistsJSON(String stringFile) {
        File file =new File(ReadJSON.ABSOLUTE_PATH +stringFile);
        return file.exists();
    }
    public static boolean fileExistsCSV(String stringFile) {
        File file =new File(ReadCSV.ABSOLUTE_PATH +stringFile);
        return file.exists();
    }
}
