package mongoDB.clase1.mongoDB.interaccion;

import com.mongodb.client.MongoDatabase;
import mongoDB.clase1.mongoDB.configuracion.ConfiguracionMongoDB;
import mongoDB.clase1.mongoDB.servicio.ServicioGestionAlumnos;

import java.util.Scanner;

public class InterfazUsuario {
    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        MongoDatabase baseDatos = ConfiguracionMongoDB.obtenerBaseDatos();

        while (true) {
            System.out.println("\n📌 Menú de Gestión de Estudiantes");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Agregar nota a estudiante");
            System.out.println("3. Calcular promedio de notas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el curso: ");
                    String curso = scanner.nextLine();
                    ServicioGestionAlumnos.agregarEstudiante(baseDatos, nombre, curso);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese la nota: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();
                    ServicioGestionAlumnos.agregarNota(baseDatos, nombre, nota);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    nombre = scanner.nextLine();
                    ServicioGestionAlumnos.calcularPromedio(baseDatos, nombre);
                    break;
                case 4:
                    System.out.println("👋 Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        iniciar();
    }
}