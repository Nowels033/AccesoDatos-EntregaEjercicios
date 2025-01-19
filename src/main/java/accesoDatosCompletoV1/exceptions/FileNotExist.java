package accesoDatosCompletoV1.exceptions;

public class FileNotExist extends RuntimeException {
    public static final String FILE_NOT_EXISTS = "El archivo introducido no existe";
    private FileNotExist(String message) {
        super(message);
    }

    public static void fileNotExist() {
        throw new FileNotExist(FILE_NOT_EXISTS);
    }
}
