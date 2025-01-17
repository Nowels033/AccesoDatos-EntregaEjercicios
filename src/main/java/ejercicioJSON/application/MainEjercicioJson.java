package ejercicioJSON.application;

import ejercicioJSON.interfaces.InputJson;
import ejercicioJSON.input.ReadJson;
import ejercicioJSON.interfaces.OutPutBBDD;
import ejercicioJSON.repository.BBDDWritePersona;

import java.util.Scanner;

public class MainEjercicioJson {
    public static void main(String[] args) {

        appJson();

    }

    public static void jsonToBBDD(String archivoJson) {
        OutPutBBDD writeSQL = new BBDDWritePersona();
        InputJson readJson = new ReadJson(archivoJson);
        writeSQL.write(readJson.read());
    }

    public static void appJson(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            opcion = comprobarEntero(sc);
            opcionesApp(opcion);

        }while(opcion !=3);


    }
    public static void opcionesMenu(){
        System.out.println(".....MANEJO DE DATOS CON LA BBDD PERSONAS.....");
        System.out.println("----1.Introducir PERSONSA a la BBDD desde archivo .Json");
        System.out.println("----2.Descargar PERSONAS DESDE la BBDD y generar nuevo fichero .Json");
        System.out.println("----3.Salir");
    }
    public static int comprobarEntero(Scanner sc) {
        int opcion = 0;
        boolean isEntero = false;

        do {
            opcionesMenu();
            System.out.println("Introduce un numero entero para elegir una opcion: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                isEntero = true;
            } else {
                System.out.println("Entrada no valida por favor, introduce un numero entero.");
                sc.next();
            }
        } while (!isEntero);

        return opcion;
    }
    public static void opcionesApp(int opcion){
        Scanner sc = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("introduce el nombre del fichero .JSON");
                String archivo = sc.nextLine();
                jsonToBBDD(archivo);
                break;
            case 2:
                break;
            case 3:
                System.out.println("Saliendo del programa....");
                break;

            default:
                System.out.println("Opcion no valida, elige una opcion del 1 al 3.");
        }


    }
}
