package ejercicioJSON.application;

import ejercicioJSON.interfaces.Input;
import ejercicioJSON.input.ReadJson;
import ejercicioJSON.repository.SqlPersona;

public class MainEjercicioJson {
    public static void main(String[] args) {
        SqlPersona sql = new SqlPersona();
        String variable = "ejemplo1.json";
        Input leer = new ReadJson(variable);
        leer.read();
    }
}
