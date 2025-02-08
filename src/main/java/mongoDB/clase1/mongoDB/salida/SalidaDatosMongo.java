package mongoDB.clase1.mongoDB.salida;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public class SalidaDatosMongo implements ISalidaDatos {
    @Override
    public void guardarDatos(MongoDatabase baseDatos, String nombreColeccion, List<Document> datosProcesados) {
        MongoCollection<Document> coleccion = baseDatos.getCollection(nombreColeccion);
        coleccion.insertMany(datosProcesados);
    }
}