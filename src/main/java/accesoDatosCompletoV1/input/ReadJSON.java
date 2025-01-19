package accesoDatosCompletoV1.input;



import accesoDatosCompletoV1.exceptions.FileNotExist;
import accesoDatosCompletoV1.interfaces.InPutInterfacePeople;
import accesoDatosCompletoV1.models.Persona;
import accesoDatosCompletoV1.output.MsgError;
import accesoDatosCompletoV1.validator.FileValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadJSON implements InPutInterfacePeople {

    private static final String ABSOLUTEPATH = "data/JSON/";
    private static String fileAbsolutePath;
    private static File ficheroJSON;
    public ReadJSON(String file) {

        //COMPROBAMOS QUE EL FICHERO JSON EXISTE
        if (!FileValidator.fileExistsJSON(file)) FileNotExist.fileNotExist();

        //SI EXISTE, GUARDAMOS LA RUTA DEL FICHERO Y CREAMOS EL OBJETO
       fileAbsolutePath = ABSOLUTEPATH + file;
       ficheroJSON = new File(fileAbsolutePath);

    }

    @Override
    public List<Persona> read() {
        ObjectMapper mapper = new ObjectMapper();
        List<Persona> personas = new ArrayList<>();
        try {

            personas = mapper.readValue(ficheroJSON, new TypeReference<>() {});

        } catch (JsonProcessingException e) {
            throw new RuntimeException(MsgError.errorLeerJson(),e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return personas;

    }

}
