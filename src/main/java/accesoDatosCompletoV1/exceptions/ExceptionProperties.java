package accesoDatosCompletoV1.exceptions;

import java.io.IOException;

public class ExceptionProperties extends RuntimeException {
    private static final String FAIL_PROPERTIES ="Error al cargar las propiedades de la conexion" ;

    private ExceptionProperties(String message) {
        super(message);
    }

    public static void failProperties()  {
        throw new ExceptionProperties(FAIL_PROPERTIES);
    }
}

