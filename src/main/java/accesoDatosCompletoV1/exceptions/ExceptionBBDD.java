package accesoDatosCompletoV1.exceptions;

public class ExceptionBBDD extends RuntimeException   {
    public static final String CONECCTION_FAIL="FALLO LA CONEXION CON LA BBDD";
    public static final String CHECK_TABLE_FAIL="Error al comprobar/crear la tabla".toUpperCase();
    private static final String CLOSE_CONNECTION_FAIL ="ERROR AL CERRAR LA CONEXION" ;
    private static final String FAIL_INSERT_PEOPLE = "Error al insertar personas".toUpperCase();
    private static final String FAIL_INSERT_ANIMALS = "Error al insertar animales";

    private ExceptionBBDD(String message) {
        super(message);
    }

    public static void connectionFail(){
        throw new ExceptionBBDD(CONECCTION_FAIL);
    }
    public static void checkTableFail(){
        throw new ExceptionBBDD(CHECK_TABLE_FAIL);
    }

    public static void closeConnectionFail() {
        throw new ExceptionBBDD(CLOSE_CONNECTION_FAIL);
    }

    public static void failInsertPeople() {
        throw new ExceptionBBDD(FAIL_INSERT_PEOPLE);
    }

    public static void failInsertAnimals() {
        throw new ExceptionBBDD(FAIL_INSERT_ANIMALS);
    }
}

