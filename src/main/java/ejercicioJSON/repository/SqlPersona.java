package ejercicioJSON.repository;

import ejercicioJSON.interfaces.Output;
import ejercicioJSON.model.Persona;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SqlPersona implements Output {

    private static final String SQL_COMPROBAR_TABLA = "CREATE TABLE IF NOT EXISTS personas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(50), " +
            "edad INT, " +
            "ciudad VARCHAR(50)" +
            ");";

    private static String url;
    private static String user;
    private static String password;
    private static Connection conn = null ;


    public SqlPersona() {
        initSqlPersona();
    }
    public void initConnection(){
        if (null == conn){

            try {
                conn = DriverManager.getConnection(url,user,password);
                System.out.println("conexion establecida");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void closeConnection(){
        if (conn != null){
            try {
                conn.close();
                System.out.println("conexion terminada");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void initSqlPersona(){
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/main/java/ejercicioJSON/configuration/sql.properties");
            properties.load(fis);
            url = properties.getProperty("URL");
            user = properties.getProperty("USER");
            password = properties.getProperty("PASSWORD");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write() {
        comprobarTablaPersonas();


    }

    @Override
    public void write(Persona persona) {
        comprobarTablaPersonas();

    }
    private void comprobarTablaPersonas(){
        initConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(SQL_COMPROBAR_TABLA);
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
