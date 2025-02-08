package mongoDB.clase1.mongoDB.configuracion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class ConfiguracionMongoDB {
    private static final String CADENA_CONEXION = "mongodb://admin:admin@localhost:27017";
    private static final String NOMBRE_BASE_DATOS = "AccesoADatos";

    public static MongoDatabase obtenerBaseDatos() {
        MongoClient clienteMongo = MongoClients.create(CADENA_CONEXION);
        MongoDatabase baseDatos = clienteMongo.getDatabase(NOMBRE_BASE_DATOS);
        crearColeccionSiNoExiste(baseDatos, "estudiantes");
        return baseDatos;
    }

    private static void crearColeccionSiNoExiste(MongoDatabase baseDatos, String nombreColeccion) {
        MongoIterable<String> colecciones = baseDatos.listCollectionNames();
        for (String coleccion : colecciones) {
            if (coleccion.equals(nombreColeccion)) {
                return;
            }
        }
        baseDatos.createCollection(nombreColeccion);
        System.out.println("✅ Colección '" + nombreColeccion + "' creada correctamente.");
    }
}