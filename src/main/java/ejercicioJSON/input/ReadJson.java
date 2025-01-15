package ejercicioJSON.input;


import ejercicioJSON.exceptions.ReadJsonException;
import ejercicioJSON.interfaces.Input;

import java.io.*;

public class ReadJson implements Input {
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
    public void read() {
        StringBuilder contenidoJson = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(getRutaCompleta()));
            String linea;
            while ((linea=br.readLine()) != null){
                contenidoJson.append(linea);
            }
            System.out.println(contenidoJson.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Boolean comprobarFichero(String archivo){
        File fichero = new File(RUTA+archivo);
        return fichero.exists();

    }
}
