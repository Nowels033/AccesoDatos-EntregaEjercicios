package ejercicioJSON.interfaces;

public interface SentenciasSql {
    String SQL_COMPROBAR_TABLA = "CREATE TABLE IF NOT EXISTS personas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(50), " +
            "edad INT, " +
            "ciudad VARCHAR(50)" +
            ");";
}
