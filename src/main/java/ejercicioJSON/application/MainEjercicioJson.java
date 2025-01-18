package ejercicioJSON.application;

import ejercicioJSON.exceptions.ReadJsonException;
import ejercicioJSON.input.Input;
import ejercicioJSON.interfaces.InputInterface;
import ejercicioJSON.input.ReadJson;
import ejercicioJSON.interfaces.OutPutBBDD;
import ejercicioJSON.model.Persona;
import ejercicioJSON.output.Output;
import ejercicioJSON.repository.BBDDWritePersona;
import ejercicioJSON.validator.Validator;

import java.sql.SQLException;
import java.util.List;

public class MainEjercicioJson {
    public static final int LOAD_FROM_JSON = 1;
    public static final int EXIT = 3;
    public static void main(String[] args) {

        boolean userWantsToExit;

        do {
            int opcion = pedirOpcionMenu();

            userWantsToExit = (opcion == 3);
            if (!userWantsToExit) {
             ejecutarTarea(opcion);

            }
        } while(!userWantsToExit);

        Output.printFarewellMessage();
        System.exit(0);
    }

    public static int pedirOpcionMenu(){
        int opcion;
        do {
            Output.mostrarMenu();
            opcion = Input.getOptionMenu();
        }while(!Validator.esOpcionDelMenu(opcion));

        return opcion;
    }

    public static void ejecutarTarea(int opcion){
        switch (opcion) {
            case LOAD_FROM_JSON:
                Output.mostrarMensajeRutaJSON();
                String jsonPath = Input.getJSONPath();
                try {
                    jsonToBBDD(jsonPath);
                } catch(ReadJsonException readJsonException) {
                    Output.mostrarMensajeJSONNoExiste(readJsonException.getMessage());
                }
                break;
            case 2:
                break;
        }
    }

    public static void jsonToBBDD(String archivoJson) throws ReadJsonException {
        InputInterface readJson = new ReadJson(archivoJson);
        OutPutBBDD writeSQL = new BBDDWritePersona();
        List<Persona> personas = readJson.read();
        try {
            writeSQL.write(personas);
        } catch (RuntimeException runtimeException) {
            Output.mostrarMensajeErrorAccesoALaBD(runtimeException.getMessage());
        } catch (SQLException e) {
            Output.mostrarMensajeErrorWhenTableCreation(e.getMessage());
        }

    }
}
