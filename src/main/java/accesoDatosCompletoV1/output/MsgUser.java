package accesoDatosCompletoV1.output;

public class MsgUser {
    public static String msgConection() {
        return "conexion exitosa en la base de datos :";
    }
    public static String msgCloseConection() {
        return "Fin de la Conexion con la base de datos :";
    }

    public static void showInsertBBDDPeople(int resultados) {
        System.out.println("Se han insertado " + resultados + " personas en la base de datos.");
    }

    public static void showInsertBBDDAnimals(int resultados) {
        System.out.println("Se han insertado " + resultados + " animales en la base de datos.");
    }
}
