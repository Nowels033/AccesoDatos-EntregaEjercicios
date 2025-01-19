package accesoDatosCompletoV1.application;

import accesoDatosCompletoV1.input.ReadJSON;
import accesoDatosCompletoV1.interfaces.InPutInterface;
import accesoDatosCompletoV1.interfaces.OutPutInterface;
import accesoDatosCompletoV1.models.Persona;
import accesoDatosCompletoV1.repository.WriteBBDDJSON;

import java.util.List;

public class App {
    public static void main(String[] args) {
//        OutPutInterface output = new WriteBBDDJSON();
//        output.write();

        InPutInterface input = new ReadJSON("ejemplo1.json");
       List<Persona> personas = input.read();

       personas.forEach(System.out::println);
    }
}
