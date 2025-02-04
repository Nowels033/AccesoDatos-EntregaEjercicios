package mongoDB.clase1.core;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.internal.connection.Connection;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public class Main {


    static String cadenaConexion = "mongodb://%s:%s@%s:%d";

    static String miConexionLocal = String.format(cadenaConexion, "noel", "noel", "localhost", 27017);


    public static void main(String[] args) {

        ConnectionString cs = new ConnectionString(miConexionLocal);

        try (MongoClient cliente = MongoClients.create(cs)) {
            MongoDatabase db = cliente.getDatabase("local");
            Bson comando = new BsonDocument("ping",new BsonInt64(1));

            System.out.println(db.runCommand(comando));

            if (cliente != null) {
                System.out.println("Informacion del cluster");
                System.out.println(cliente.getClusterDescription());
            }
            System.out.println("Bases de datos:");
            ListDatabasesIterable<Document> basesDeDatos = cliente.listDatabases();

            int i = 1;
            for (Document base : basesDeDatos) {
                //System.out.println(base.toJson());
                System.out.println(String.format("%d-) %s\n",i,base.toString()));
                i++;
            }

            MongoCollection<Document> coleccion = db.getCollection("startup_log");

            Bson proyectionFields = Projections.fields(Projections.include("pid"));


            Bson doc = coleccion.find(eq("hostname","AL12090")).projection(proyectionFields).first();

            System.out.println(doc);

             coleccion = db.getCollection("orders");

             try {
                 InsertOneResult result = coleccion.insertOne(new Document().append("_id",new ObjectId()).append("title","SKI BLOOPERS").append("genres", Arrays.asList("Documentary","Comedy"))
                         .append("newField","nuevo campo"));
                 InsertOneResult result2 = coleccion.insertOne(new Document().append("_id",new ObjectId()).append("title","SKI BLOOPERS").append("genres", Arrays.asList("Documentary","Comedy")));

                 System.out.println("RESULTADO : insertado el documento id= "+result.getInsertedId());
             } catch (MongoException e) {
                 System.err.println("ERROR : " + e.getMessage());
             }

             try {
                 DeleteResult deleteResult = coleccion.deleteOne(eq("newField","nuevo campo"));
                 System.out.println("RESULTADO : delete "+deleteResult.getDeletedCount());
             }catch (MongoException e) {
                 System.err.println("ERROR : " + e.getMessage());
             }




        }





    }
}
