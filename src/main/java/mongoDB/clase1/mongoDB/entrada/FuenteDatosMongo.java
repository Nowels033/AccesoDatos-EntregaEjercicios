package mongoDB.clase1.mongoDB.entrada;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public class FuenteDatosMongo implements IFuenteDatos {
    @Override
    public List<Document> obtenerDatos(MongoDatabase baseDatos, String nombreColeccion) {
        MongoCollection<Document> coleccion = baseDatos.getCollection(nombreColeccion);
        return coleccion.find().into(new java.util.ArrayList<>());
    }
}