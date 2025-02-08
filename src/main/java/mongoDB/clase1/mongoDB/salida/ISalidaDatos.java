package mongoDB.clase1.mongoDB.salida;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public interface ISalidaDatos {
    void guardarDatos(MongoDatabase baseDatos, String nombreColeccion, List<Document> datosProcesados);
}