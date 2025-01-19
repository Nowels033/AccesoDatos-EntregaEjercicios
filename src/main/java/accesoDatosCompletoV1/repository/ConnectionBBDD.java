package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.output.MsgError;
import accesoDatosCompletoV1.output.MsgUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionBBDD {
    private static final String PROPERTIESHOUSE = "configuration/SqlCasa.properties";
    private static final String PROPERTIESOUTHOUSE = "configuration/SqlClase.properties";
    private static String url;
    private static String user;
    private static String password;
    private static Connection conn = null;


    public ConnectionBBDD() {
        initProperties();
    }
    public static void initConnection()  {
        if (conn == null || isConnectionClosed()) {
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println(MsgUser.msgConection() +url);
            } catch (SQLException e) {
                throw new RuntimeException(MsgError.errorBBDD(),e);
            }

        }
    }

    public static boolean isConnectionClosed() {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            throw new RuntimeException(MsgError.errorBBDD());
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println(MsgUser.msgCloseConection());
            } catch (SQLException e) {
                throw new RuntimeException(MsgError.errorPropierties());
            }
        }
    }

    public static void initProperties() {

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIESHOUSE)) {
            properties.load(fis);
            url = properties.getProperty("URL");
            user = properties.getProperty("USER");
            password = properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException(MsgError.errorPropierties());
        }


    }

}
