package accesoDatosCompletoV1.output;

public class MsgError {
    public static String errorPropierties() {
        return "Error al cargar las propiedades de la conexion";
    }
    public static String errorBBDD() {
        return "Error al acceder a la BBDD";
    }
    public static String errorLeerJson() {
        return "Error al procesar el archiv  .JSON";
    }
}
