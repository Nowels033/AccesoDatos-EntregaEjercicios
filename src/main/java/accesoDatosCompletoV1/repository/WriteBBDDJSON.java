package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.interfaces.OutPutInterface;
import accesoDatosCompletoV1.models.Persona;

import java.util.List;

public class WriteBBDDJSON extends ConnectionBBDD implements OutPutInterface {
    public WriteBBDDJSON() {
        super();
    }

    @Override
    public void write(List<Persona> personas) {
        initConnection();

        closeConnection();
    }
}
