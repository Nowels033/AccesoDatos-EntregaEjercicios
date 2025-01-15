package ejercicioJSON.io;


import ejercicioJSON.interfaces.Input;

import java.io.*;

public class ReadJson implements Input {
    private static final String ruta = "src/main/java/ejercicioJSON/filesJson/";
    private String rutaCompleta;
    public ReadJson(String archivo) {
        if (comprobarFichero(archivo)){
            this.rutaCompleta= ruta+ archivo;
        }

        else{
            this.rutaCompleta=null;
        }

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
        File fichero = new File(ruta+archivo);

        if (!fichero.exists()){
            System.out.println("Fichero: "+archivo+", no se encuentra en el directorio : "+ruta);
            return false;
        }
        return true;

    }
}
