package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:concurso.db";
    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                System.err.println("Error al conectar: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void crearTablas() {
        String sqlConcurso = """
                CREATE TABLE IF NOT EXISTS concurso (
                    id TEXT PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    fecha_inicio DATE NOT NULL,
                    fecha_fin DATE NOT NULL
                );
                """;

        String sqlParticipante = """
                CREATE TABLE IF NOT EXISTS participante (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    apellido TEXT NOT NULL,
                    dni TEXT NOT NULL UNIQUE,
                    puntos INTEGER NOT NULL DEFAULT 0,
                    concurso_id TEXT NOT NULL,
                    FOREIGN KEY (concurso_id) REFERENCES concurso(id)
                );
                """;

        try (Statement stmt = connect().createStatement()) {
            stmt.execute(sqlConcurso);
            stmt.execute(sqlParticipante);
        } catch (SQLException e) {
            System.err.println("Error al crear tablas: " + e.getMessage());
        }
    }

    public static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}
