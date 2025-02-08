package mongoDB.clase1.mongoDB.entrada;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public interface IFuenteDatos {
    List<Document> obtenerDatos(MongoDatabase baseDatos, String nombreColeccion);
}