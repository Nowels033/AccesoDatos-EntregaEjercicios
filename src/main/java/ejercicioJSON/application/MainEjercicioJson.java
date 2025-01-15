package ejercicioJSON.application;

import ejercicioJSON.io.ReadJson;
import ejercicioJSON.repository.SqlPersona;

public class MainEjercicioJson {
    public static void main(String[] args) {
        SqlPersona sql = new SqlPersona();
        String variable = "";
        ReadJson leer = new ReadJson(variable);
        leer.read();
    }
}
