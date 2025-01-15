package ejercicioJSON.application;

import ejercicioJSON.repository.SqlPersona;

public class MainEjercicioJson {
    public static void main(String[] args) {
        SqlPersona sql = new SqlPersona();

        sql.initConnection();
        sql.closeConnection();
    }
}
