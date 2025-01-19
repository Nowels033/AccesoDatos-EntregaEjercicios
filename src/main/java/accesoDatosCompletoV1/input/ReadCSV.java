package accesoDatosCompletoV1.input;

import accesoDatosCompletoV1.exceptions.FileNotExist;
import accesoDatosCompletoV1.interfaces.InPutInterface;
import accesoDatosCompletoV1.validator.FileValidator;

public class ReadCSV implements InPutInterface {
    private static final String ABSOLUTEPATH = "data/JSON/";
    private  String fileAbsolutePath;
    public ReadCSV(String file) {

        //COMPROBAMOS QUE EL FICHERO JSON EXISTE
        if (!FileValidator.fileExistsCSV(file)) FileNotExist.fileNotExist();

        //SI EXISTE, GUARDAMOS LA RUTA DEL FICHERO Y CREAMOS EL OBJETO
        fileAbsolutePath = ABSOLUTEPATH + file;

    }

    @Override
    public void read() {

    }
}
