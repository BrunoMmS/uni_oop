package JDBC;

import Models.Concurso;

import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class ConcursoJDBC {

    public static void crear(Concurso concurso) {
        var db = DatabaseManager.connect();
        String query = "INSERT INTO Concurso (id, nombre, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?)";

        try (var stmt = db.prepareStatement(query)) {
            stmt.setString(1, concurso.getId().toString()); // UUID como string
            stmt.setString(2, concurso.getNombre());
            stmt.setLong(3, concurso.getStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
            stmt.setLong(4, concurso.getEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Concurso find(UUID idConcurso) {
        var db = DatabaseManager.connect();
        String query = "SELECT * FROM Concurso WHERE id = ?";

        try (var stmt = db.prepareStatement(query)) {
            stmt.setString(1, idConcurso.toString()); // Buscar por UUID como string
            var rs = stmt.executeQuery();

            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String nombre = rs.getString("nombre");

                long inicioMillis = rs.getLong("fecha_inicio");
                long finMillis = rs.getLong("fecha_fin");

                ZoneId zone = ZoneId.systemDefault();
                LocalDate fechaInicio = Instant.ofEpochMilli(inicioMillis).atZone(zone).toLocalDate();
                LocalDate fechaFin = Instant.ofEpochMilli(finMillis).atZone(zone).toLocalDate();

                return new Concurso(id, nombre, fechaInicio, fechaFin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
