package ejercicioJSON.input;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicioJSON.exceptions.ReadJsonException;
import ejercicioJSON.interfaces.InputJson;
import ejercicioJSON.model.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadJson implements InputJson {
    private static final String RUTA = "src/main/java/ejercicioJSON/filesJson/";
    private String rutaCompleta;
    public ReadJson(String archivo) {
        if (!comprobarFichero(archivo)) throw new ReadJsonException("El archivo introducido no existe");
        this.rutaCompleta= RUTA+ archivo;
    }

    public String getRutaCompleta() {
        return rutaCompleta;
    }

    public void setRutaCompleta(String rutaCompleta) {
        this.rutaCompleta = rutaCompleta;
    }

    @Override
    public List<Persona> read() {
        ObjectMapper mapper = new ObjectMapper();
        List<Persona> personas = new ArrayList<>();

        try {
            File archivoJson = new File(getRutaCompleta());


            try {
                Persona persona = mapper.readValue(archivoJson, Persona.class);
                System.out.println("Persona : " + persona);
                personas.add(persona);

            } catch (JsonProcessingException e) {
                 personas = mapper.readValue(archivoJson, new TypeReference<List<Persona>>() {});
               // System.out.println("Lista de personas: ");
//                for (int i = 0; i < personas.size(); i++) {
//
//
//
//                }

            }


        } catch (IOException e) {
            System.err.println("error al leer el archivo JSON: " + e.getMessage());
        }
        return personas;
    }

    public static Boolean comprobarFichero(String archivo){
        File fichero = new File(RUTA+archivo);
        return fichero.exists();

    }
}
