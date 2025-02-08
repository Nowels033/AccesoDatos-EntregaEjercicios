package mongoDB.clase1.core;

import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import java.util.Arrays;

public class MongoDBJavaCRUD {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "miBaseDatos";
    private static final String COLLECTION_NAME = "usuarios";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            crearColeccion(database);
            insertarUsuario(collection);
            insertarUsuarios(collection);
            leerUsuarios(collection);
            buscarUsuario(collection);
            actualizarUsuario(collection);
            eliminarUsuario(collection);
            crearIndice(collection);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void crearColeccion(MongoDatabase database) {
        database.createCollection(COLLECTION_NAME);
        System.out.println("✅ Colección 'usuarios' creada correctamente.");
    }

    private static void insertarUsuario(MongoCollection<Document> collection) {
        Document usuario = new Document("nombre", "Carlos")
                .append("edad", 28)
                .append("email", "carlos@email.com");
        collection.insertOne(usuario);
        System.out.println("✅ Usuario insertado correctamente.");
    }

    private static void insertarUsuarios(MongoCollection<Document> collection) {
        Document usuario1 = new Document("nombre", "Ana").append("edad", 30);
        Document usuario2 = new Document("nombre", "Luis").append("edad", 25);
        collection.insertMany(Arrays.asList(usuario1, usuario2));
        System.out.println("✅ Usuarios insertados correctamente.");
    }

    private static void leerUsuarios(MongoCollection<Document> collection) {
        FindIterable<Document> usuarios = collection.find();
        for (Document doc : usuarios) {
            System.out.println(doc.toJson());
        }
    }

    private static void buscarUsuario(MongoCollection<Document> collection) {
        Document usuarioEncontrado = collection.find(eq("nombre", "Carlos")).first();
        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado: " + usuarioEncontrado.toJson());
        }
    }

    private static void actualizarUsuario(MongoCollection<Document> collection) {
        collection.updateOne(eq("nombre", "Carlos"), set("edad", 29));
        System.out.println("✅ Usuario actualizado correctamente.");
    }

    private static void eliminarUsuario(MongoCollection<Document> collection) {
        collection.deleteOne(eq("nombre", "Carlos"));
        System.out.println("✅ Usuario eliminado correctamente.");
    }

    private static void crearIndice(MongoCollection<Document> collection) {
        collection.createIndex(new Document("email", 1));
        System.out.println("✅ Índice creado en el campo 'email'");
    }
}
