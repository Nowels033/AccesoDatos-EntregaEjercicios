package ejercicioJSON.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlPersona {
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
}
