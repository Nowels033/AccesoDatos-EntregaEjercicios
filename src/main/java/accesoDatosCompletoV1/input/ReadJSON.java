package accesoDatosCompletoV1.input;



import accesoDatosCompletoV1.exceptions.FileNotExist;
import accesoDatosCompletoV1.interfaces.InPutInterface;
import accesoDatosCompletoV1.validator.FileValidator;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ReadJSON implements InPutInterface {

    private static final String ABSOLUTEPATH = "data/JSON/";
    private static String fileAbsolutePath;
    public ReadJSON(String file) {

        //COMPROBAMOS QUE EL FICHERO JSON EXISTE
        if (!FileValidator.fileExistsJSON(file)) FileNotExist.fileNotExist();

        //SI EXISTE, GUARDAMOS LA RUTA DEL FICHERO Y CREAMOS EL OBJETO
       fileAbsolutePath = ABSOLUTEPATH + file;

    }

    @Override
    public void read() {
        ObjectMapper mapper = new ObjectMapper();



    }


}
