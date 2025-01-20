package accesoDatosCompletoV1.repository;

import accesoDatosCompletoV1.exceptions.ExceptionBBDD;
import accesoDatosCompletoV1.exceptions.ExceptionProperties;
import accesoDatosCompletoV1.output.MsgUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionBBDD {
    private static final String PROPERTIES_HOUSE = "configuration/SqlCasa.properties";
    private static final String PROPERTIES_OUT_HOUSE = "configuration/SqlClase.properties";
    private static String url;
    private static String user;
    private static String password;
    protected static Connection conn = null;


    public ConnectionBBDD() {
        initProperties();
    }
    public static void initConnection()  {
        if (conn == null || isConnectionClosed()) {
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println(MsgUser.msgConection() +url);
            } catch (SQLException | ExceptionBBDD e) {
                ExceptionBBDD.connectionFail();
            }

        }
    }

    public static boolean isConnectionClosed() {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException| ExceptionBBDD e) {
            ExceptionBBDD.closeConnectionFail();
            return false;
            //throw new RuntimeException(MsgError.errorBBDD(),e);
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println(MsgUser.msgCloseConection());
            } catch (SQLException| ExceptionBBDD e) {
                ExceptionBBDD.closeConnectionFail();
                //throw new RuntimeException(MsgError.errorBBDD(),e);
            }
        }
    }

    public static void initProperties() {

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_OUT_HOUSE)) {
            properties.load(fis);
            url = properties.getProperty("URL");
            user = properties.getProperty("USER");
            password = properties.getProperty("PASSWORD");
        } catch (IOException | ExceptionProperties e) {
            ExceptionProperties.failProperties();
            throw new RuntimeException(e);
        }


    }

}
