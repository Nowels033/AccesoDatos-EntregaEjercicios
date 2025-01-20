package accesoDatosCompletoV1.application;

import accesoDatosCompletoV1.input.ReadCSV;
import accesoDatosCompletoV1.input.ReadJSON;
import accesoDatosCompletoV1.interfaces.InPutInterfaceAnimal;
import accesoDatosCompletoV1.interfaces.InPutInterfacePeople;
import accesoDatosCompletoV1.interfaces.OutPutInterfaceAnimal;
import accesoDatosCompletoV1.interfaces.OutPutInterfacePeople;
import accesoDatosCompletoV1.repository.WriteBBDDCSV;
import accesoDatosCompletoV1.repository.WriteBBDDJSON;

public class App {
    public static void main(String[] args) {

        saveBBDDPersonasInPutJSON();
        saveBBDDAnimalesInPutCSV();
    }

    public static void saveBBDDPersonasInPutJSON() {
        InPutInterfacePeople input = new ReadJSON("ejemplo1.json");
        OutPutInterfacePeople output = new WriteBBDDJSON();
        output.write(input.read());
    }
    public static void saveBBDDAnimalesInPutCSV() {
        InPutInterfaceAnimal input = new ReadCSV("animales1.csv");
        OutPutInterfaceAnimal output = new WriteBBDDCSV();
        output.write(input.read());
    }
}
