package ejercicioJSON.interfaces;

import ejercicioJSON.model.Persona;

import java.sql.SQLException;
import java.util.List;

public interface OutPutBBDD {
    void write(List<Persona> personas) throws RuntimeException, SQLException;
}
