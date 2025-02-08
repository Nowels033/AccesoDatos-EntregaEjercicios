package mongoDB.clase1.mongoDB.servicio;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongoDB.clase1.mongoDB.procesamiento.IProcesadorDatos;
import mongoDB.clase1.mongoDB.procesamiento.ProcesadorDatos;
import org.bson.Document;
import java.util.List;

public class ServicioGestionAlumnos {
    public static void agregarEstudiante(MongoDatabase baseDatos, String nombre, String curso) {
        Document estudiante = new Document("nombre", nombre)
                .append("curso", curso)
                .append("notas", new java.util.ArrayList<Double>());
        baseDatos.getCollection("estudiantes").insertOne(estudiante);
        System.out.println("✅ Estudiante agregado correctamente.");
    }

    public static void agregarNota(MongoDatabase baseDatos, String nombre, double nota) {
        MongoCollection<Document> coleccion = baseDatos.getCollection("estudiantes");
        Document estudiante = coleccion.find(new Document("nombre", nombre)).first();
        if (estudiante != null) {
            List<Double> notas = (List<Double>) estudiante.get("notas");
            notas.add(nota);
            coleccion.updateOne(new Document("nombre", nombre), new Document("$set", new Document("notas", notas)));
            System.out.println("✅ Nota agregada correctamente.");
        } else {
            System.out.println("⚠️ Estudiante no encontrado.");
        }
    }

    public static void calcularPromedio(MongoDatabase baseDatos, String nombre) {
        MongoCollection<Document> coleccion = baseDatos.getCollection("estudiantes");
        Document estudiante = coleccion.find(new Document("nombre", nombre)).first();
        if (estudiante != null) {
            List<Double> notas = (List<Double>) estudiante.get("notas");
            IProcesadorDatos procesador = new ProcesadorDatos();
            double promedio = procesador.calcularPromedioNotas(notas);
            System.out.println("📊 Promedio de " + nombre + ": " + promedio);
        } else {
            System.out.println("⚠️ Estudiante no encontrado.");
        }
    }
}