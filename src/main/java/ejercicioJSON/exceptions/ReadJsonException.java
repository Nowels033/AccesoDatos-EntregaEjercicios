package ejercicioJSON.exceptions;

public class ReadJsonException extends RuntimeException {
    private static final String JSON_NOT_EXISTS = "El archivo introducido no existe";
    private static final String JSON_PROCESSING_ERROR = "Hubo un error durante el procesamiento del JSON";
    private static final String JSON_ACCESSING_ERROR = "Hubo un error durante el acceso al JSON";

    private ReadJsonException(String message) {
        super(message);
    }

    public static void fromCheckExists() {
        throw new ReadJsonException(JSON_NOT_EXISTS);
    }

    public static void fromJsonProcessing() {
        throw new ReadJsonException(JSON_PROCESSING_ERROR);
    }

    public static void fromJsonAccesing() {
        throw new ReadJsonException(JSON_ACCESSING_ERROR);
    }
}
