package ejercicioJSON.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

abstract class ConnBBDDPersonas {

    protected static final String SQL_COMPROBAR_TABLA = "CREATE TABLE IF NOT EXISTS personas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(50), " +
            "edad INT, " +
            "ciudad VARCHAR(50)" +
            ");";


    private static String url;
    private static String user;
    private static String password;
    protected static Connection conn = null;

    public ConnBBDDPersonas() {
        initSqlPersona();
    }


    public void initConnection() throws SQLException {
        if (conn == null || isConnectionClosed()) {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida en "+url);
        }
    }

    private boolean isConnectionClosed() {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo cerrar la conexión a la base de datos", e);
        }
    }
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexion terminada");
            } catch (SQLException e) {
                throw new RuntimeException("Error", e);
            }
        }
    }
    public static void initSqlPersona() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/java/ejercicioJSON/configuration/sql.properties")) {
            properties.load(fis);
            url = properties.getProperty("URL");
            user = properties.getProperty("USER");
            password = properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar las propiedades de la conexion", e);
        }
    }



    protected void comprobarTablaPersonas() throws RuntimeException, SQLException {
        initConnection();
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL_COMPROBAR_TABLA);
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar/crear la tabla 'personas'", e);
        }
    }
}