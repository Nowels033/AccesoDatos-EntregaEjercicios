package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.interfaces.OutPutInterface;

public class WriteBBDDJSON extends ConnectionBBDD implements OutPutInterface {
    public WriteBBDDJSON() {
        super();
    }

    @Override
    public void write() {
        initConnection();
        closeConnection();
    }
}
