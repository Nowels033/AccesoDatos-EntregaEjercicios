package accesoDatosCompletoV1.exceptions;

public class ExceptionCSV extends RuntimeException {
  private static final String FAIL_PROCESSING_CSV = "ERROR AL PROCESAR EL ARCHIVO .CSV";

  private ExceptionCSV(String message) {
    super(message);
  }

  public static void failProcessingCSV(){
    throw  new ExceptionCSV(FAIL_PROCESSING_CSV);
  }
}
