package ejercicioJSON.output;

import java.util.Scanner;

public class Output {

    public static void mostrarMenu(){
        System.out.println(".....MANEJO DE DATOS CON LA BBDD PERSONAS.....");
        System.out.println("----1.Introducir PERSONSA a la BBDD desde archivo .Json");
        System.out.println("----2.Descargar PERSONAS DESDE la BBDD y generar nuevo fichero .Json");
        System.out.println("----3.Salir");
    }

    public static void mostrarMensajeRutaJSON() {
        System.out.println("Introduce el nombre del fichero .JSON");
    }

    public static void mostrarMensajeJSONNoExiste(String msg) {
        mostrarMensajesError(msg);
    }

    public static void mostrarMensajeErrorAccesoALaBD(String msg) {
        mostrarMensajesError(msg);
    }

    public static void mostrarMensajeErrorWhenTableCreation(String msg) {
        mostrarMensajesError(msg);
    }

    private static void mostrarMensajesError(String msg) {
        System.err.println(msg);
    }

    public static void printFarewellMessage() {
        System.out.println("Gracias por usar la aplicación");
    }
}
