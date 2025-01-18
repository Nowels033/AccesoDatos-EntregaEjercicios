package ejercicioJSON.input;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicioJSON.exceptions.ReadJsonException;
import ejercicioJSON.interfaces.InputInterface;
import ejercicioJSON.model.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadJson implements InputInterface {
    private static File ficheroJSON;
    private static final String RUTA = "src/main/java/ejercicioJSON/filesJson/";
    private static String absoluteJSONPath;
    public ReadJson(String nombreArchivo) throws ReadJsonException {
        absoluteJSONPath = RUTA + nombreArchivo;

        if (!comprobarFichero()) ReadJsonException.fromCheckExists();
    }

    @Override
    public List<Persona> read() {
        ObjectMapper mapper = new ObjectMapper();
        List<Persona> personas = new ArrayList<>();

        try {
            personas = mapper.readValue(ficheroJSON, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            ReadJsonException.fromJsonProcessing();
        } catch (IOException e) {
            ReadJsonException.fromJsonAccesing();
        }

        return personas;
    }

    public static Boolean comprobarFichero(){
        ficheroJSON = new File(absoluteJSONPath);
        return ficheroJSON.exists();
    }
}
