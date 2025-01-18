package ejercicioJSON.validator;

import ejercicioJSON.application.MainEjercicioJson;

public class Validator {

    public static boolean esOpcionDelMenu(int opcion) {
        return opcion >= MainEjercicioJson.LOAD_FROM_JSON && opcion <= MainEjercicioJson.EXIT;
    }
}
