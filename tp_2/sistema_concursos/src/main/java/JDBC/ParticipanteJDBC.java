package JDBC;

import Models.Participante;
import java.sql.SQLException;

public class ParticipanteJDBC {
    public static void crear(Participante participante) {
        var db = DatabaseManager.connect();
        String query = "INSERT INTO Participante (nombre, apellido, dni, puntos, concurso_id) VALUES (?, ?, ?, ?, ?)";

        try (var stmt = db.prepareStatement(query)) {
            stmt.setString(1, participante.getName());
            stmt.setString(2, participante.getLastName());
            stmt.setString(3, participante.getDni());
            stmt.setInt(4, participante.getPoints());
            stmt.setString(5, participante.getIdConcurso().toString());
            stmt.executeUpdate();
            DatabaseManager.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
