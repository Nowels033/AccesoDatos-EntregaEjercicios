package accesoDatosCompletoV1.exceptions;

public class FileNotExist extends RuntimeException {
    private FileNotExist(String message) {
        super(message);
    }

    public static void fileNotExist() {
        throw new FileNotExist("El archivo introducido no existe");
    }
}
