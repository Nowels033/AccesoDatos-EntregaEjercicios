package accesoDatosCompletoV1.application;

import accesoDatosCompletoV1.input.ReadJSON;
import accesoDatosCompletoV1.interfaces.InPutInterfacePeople;
import accesoDatosCompletoV1.interfaces.OutPutInterfacePeople;
import accesoDatosCompletoV1.repository.WriteBBDDJSON;

public class App {
    public static void main(String[] args) {


       InPutInterfacePeople input = new ReadJSON("ejemplo1.json");
        OutPutInterfacePeople output = new WriteBBDDJSON();
        output.write(input.read());



    }
}
