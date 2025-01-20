package accesoDatosCompletoV1.input;

import accesoDatosCompletoV1.exceptions.ExceptionCSV;
import accesoDatosCompletoV1.exceptions.FileNotExist;
import accesoDatosCompletoV1.interfaces.InPutInterfaceAnimal;
import accesoDatosCompletoV1.interfaces.InPutInterfacePeople;
import accesoDatosCompletoV1.models.Animal;
import accesoDatosCompletoV1.models.Persona;
import accesoDatosCompletoV1.validator.FileValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV implements InPutInterfaceAnimal {
    private static final String ABSOLUTEPATH = "data/CSV/";
    private  String fileAbsolutePath;
    public ReadCSV(String file) {

        //COMPROBAMOS QUE EL FICHERO JSON EXISTE
        if (!FileValidator.fileExistsCSV(file)) FileNotExist.fileNotExist();

        //SI EXISTE, GUARDAMOS LA RUTA DEL FICHERO Y CREAMOS EL OBJETO
        fileAbsolutePath = ABSOLUTEPATH + file;

    }


    @Override
    public List<Animal> read() {
        List<Animal> animales = new ArrayList<>();
        Animal animal= null ;
        try (BufferedReader br = new BufferedReader(new FileReader(fileAbsolutePath))) {
            String line;
            boolean primeraLineaCsv = true;

            while ((line = br.readLine()) != null) {
                // cambiar a true o false si contiene los encabezados
                if (primeraLineaCsv) {
                    primeraLineaCsv = false;
                    continue;
                }
                // cambiar ',' por el caracter separador del csv
                String[] datos = line.split(",");


                String nombre = datos[0];
                String especie = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String color = datos[3];
                String habitat = datos[4];

               animal = new Animal(nombre, especie, edad, color, habitat);
                animales.add(animal);
            }

        } catch (IOException | ExceptionCSV e) {
            //System.err.println(e);
            ExceptionCSV.failProcessingCSV();

        }


        return animales;
    }
}
