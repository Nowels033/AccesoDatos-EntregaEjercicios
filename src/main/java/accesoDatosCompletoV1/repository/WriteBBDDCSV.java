package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.exceptions.ExceptionBBDD;
import accesoDatosCompletoV1.interfaces.OutPutInterfaceAnimal;
import accesoDatosCompletoV1.interfaces.OutPutInterfacePeople;
import accesoDatosCompletoV1.models.Animal;
import accesoDatosCompletoV1.models.Persona;
import accesoDatosCompletoV1.output.MsgUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WriteBBDDCSV extends ConnectionBBDD implements OutPutInterfaceAnimal {

    private static final String SQL_COMPROBAR_TABLA = "CREATE TABLE IF NOT EXISTS animales (\n" +
            "    Nombre VARCHAR(50) NOT NULL,\n" +
            "    Especie VARCHAR(50) NOT NULL,\n" +
            "    Edad INT NOT NULL,\n" +
            "    Color VARCHAR(50),\n" +
            "    Habitat VARCHAR(50)\n" +
            ");";
    private static final String SQL_INSERTAR_ANIMAL ="INSERT INTO Animales (Nombre, Especie, Edad, Color, Habitat) VALUES\n" +
            "(?,?,?,?,?)" ;

    public WriteBBDDCSV() {
        super();
    }


    protected void comprobarTablaAnimales(){
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL_COMPROBAR_TABLA);
        } catch (SQLException | ExceptionBBDD e) {
            ExceptionBBDD.checkTableFail();
            //System.err.println(e);
        }
    }

    @Override
    public void write(List<Animal> animals) {
        initConnection();
        comprobarTablaAnimales();
        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERTAR_ANIMAL)) {
            for (Animal animal : animals) {
                preparedStatement.setString(1, animal.getNombre());
                preparedStatement.setString(2, animal.getEspecie());
                preparedStatement.setInt(3, animal.getEdad());
                preparedStatement.setString(4, animal.getColor());
                preparedStatement.setString(5, animal.getHabitat());
                preparedStatement.addBatch();
            }
            int[] resultados = preparedStatement.executeBatch();
            MsgUser.showInsertBBDDAnimals(resultados.length);
        } catch (SQLException | ExceptionBBDD ex) {
            ExceptionBBDD.failInsertAnimals();
            //throw new RuntimeException("Error al insertar personas", ex);
        }
        closeConnection();
    }
}
