package ejercicioJSON.repository;

import ejercicioJSON.interfaces.OutPutBBDD;
import ejercicioJSON.model.Persona;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BBDDWritePersona extends ConnBBDDPersonas implements OutPutBBDD {
    public BBDDWritePersona() {

    }

    @Override
    public void write(List<Persona> personas) {
        initConnection();
        comprobarTablaPersonas();
        insertPersonas(personas,SQL_INSERTAR_PERSONA);
        closeConnection();
    }
    public static void insertPersonas(List<Persona> personas ,String consultaSql ){
        try (PreparedStatement preparedStatement = conn.prepareStatement(consultaSql)) {
            for (Persona persona : personas) {
                preparedStatement.setString(1, persona.getNombre());
                preparedStatement.setInt(2, persona.getEdad());
                preparedStatement.setString(3, persona.getCiudad());
                preparedStatement.addBatch();
            }
            int[] resultados = preparedStatement.executeBatch();
            System.out.println("Se han insertado " + resultados.length + " personas en la base de datos.");
        } catch (SQLException ex) {
            throw new RuntimeException("Error al insertar personas", ex);
        }
    }
}

