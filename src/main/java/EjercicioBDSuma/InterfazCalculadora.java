package EjercicioBDSuma;

import java.util.Scanner;

public class InterfazCalculadora {

    public static void menu(Calculadora calc) {
        

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. SUMAR NUMEROS EN LA BASE DE DATOS \n2. GUARDAR NUMERO EN LA BASE DE DATOS \n3. SALIR");

             opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    calc.sumar();
                    break;
                case 2:
                calc.guardarEnMemoria();
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 3);

    }

}
