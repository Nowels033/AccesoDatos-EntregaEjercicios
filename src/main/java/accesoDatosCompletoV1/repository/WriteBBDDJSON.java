package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.exceptions.ExceptionBBDD;
import accesoDatosCompletoV1.interfaces.OutPutInterfacePeople;
import accesoDatosCompletoV1.models.Persona;
import accesoDatosCompletoV1.output.MsgUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WriteBBDDJSON extends ConnectionBBDD implements OutPutInterfacePeople {

    private static final String SQL_COMPROBAR_TABLA = "CREATE TABLE IF NOT EXISTS personas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(50), " +
            "edad INT, " +
            "ciudad VARCHAR(50)" +
            ");";
    private static final String SQL_INSERTAR_PERSONA = "INSERT INTO personas (nombre, edad, ciudad) VALUES (?, ?, ?)";

    public WriteBBDDJSON() {
        super();
    }

    @Override
    public void write(List<Persona> personas) {
        initConnection();
        comprobarTablaPersonas();
        try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERTAR_PERSONA)) {
            for (Persona persona : personas) {
                preparedStatement.setString(1, persona.getNombre());
                preparedStatement.setInt(2, persona.getEdad());
                preparedStatement.setString(3, persona.getCiudad());
                preparedStatement.addBatch();
            }
            int[] resultados = preparedStatement.executeBatch();
            MsgUser.showInsertBBDDPeople(resultados.length);
        } catch (SQLException | ExceptionBBDD ex) {
            ExceptionBBDD.failInsertPeople();
            //throw new RuntimeException("Error al insertar personas", ex);
        }


        closeConnection();
    }
    protected void comprobarTablaPersonas(){
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL_COMPROBAR_TABLA);
        } catch (SQLException | ExceptionBBDD e) {
            ExceptionBBDD.checkTableFail();
            //System.err.println(e);
        }
    }
}
