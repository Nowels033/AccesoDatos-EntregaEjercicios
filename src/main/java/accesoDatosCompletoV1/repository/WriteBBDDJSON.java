package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.interfaces.OutPutInterfacePeople;
import accesoDatosCompletoV1.models.Persona;

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

    public WriteBBDDJSON() {
        super();
    }

    @Override
    public void write(List<Persona> personas) {
        initConnection();
        comprobarTablaPersonas();

        closeConnection();
    }
    protected void comprobarTablaPersonas(){
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL_COMPROBAR_TABLA);
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar/crear la tabla 'personas'", e);
        }
    }
}
