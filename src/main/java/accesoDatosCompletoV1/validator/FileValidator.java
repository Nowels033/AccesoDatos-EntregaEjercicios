package accesoDatosCompletoV1.validator;

import java.io.File;

public class FileValidator {
    private static final String ABSOLUTE_JSON_PATH = "data/JSON/";
    private static final String ABSOLUTE_CSV_PATH = "data/CSV/";
    public static boolean fileExistsJSON(String stringFile) {
        File file =new File(ABSOLUTE_JSON_PATH+stringFile);
        return file.exists();
    }
    public static boolean fileExistsCSV(String stringFile) {
        File file =new File(ABSOLUTE_CSV_PATH+stringFile);
        return file.exists();
    }
}
