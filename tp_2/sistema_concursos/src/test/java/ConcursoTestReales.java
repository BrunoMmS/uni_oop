import Exporters.DatabaseExporter;
import Exporters.FileExporter;
import JDBC.ConcursoJDBC;
import Models.Concurso;
import Models.Participante;
import Notifications.EmailNotification;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTestReales {

    @Test
    public void debeGuardarParticipanteEnArchivoConFileExporter() {
        // Preparación
        var fileExporter = new FileExporter();
        var participante = new Participante("Julio", "Sosa", "123456");
        var concurso = new Concurso(
                "Best Linuxero",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                new EmailNotification()
        );

        // Acción
        concurso.inscribirParticipante(participante, LocalDate.now().plusDays(3), fileExporter);

        // Verificación
        assertTrue(concurso.estaParticipante(participante));
    }

    @Test
    public void debeGuardarParticipanteEnBDYAsignarPuntosConDatabaseExporter() {
        // Preparación
        var databaseExporter = new DatabaseExporter();
        var participante = new Participante("Maximiliano", "Sosa", "12345456");
        var concurso = new Concurso(
                "Best Linuxero",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                new EmailNotification()
        );

        ConcursoJDBC.crear(concurso);

        // Acción
        concurso.inscribirParticipante(participante, LocalDate.now(), databaseExporter);

        // Verificación
        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
    }

    @Test
    public void debeNotificarPorEmailAlInscribirParticipante() {
        // Preparación
        var fileExporter = new FileExporter();
        var participante = new Participante("Maximiliano", "Sosa", "1234545699");
        var concurso = new Concurso(
                "Best Linuxero",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                new EmailNotification()
        );

        ConcursoJDBC.crear(concurso);

        // Acción
        concurso.inscribirParticipante(participante, LocalDate.now(), fileExporter);

        // Verificación
        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
    }

    @Test
    public void noDebePermitirInscripcionFueraDeRangoDeFechas() {
        // Preparación
        var fileExporter = new FileExporter();
        var participante = new Participante("Maximiliano", "Sosa", "1234560000");
        var concurso = new Concurso(
                "Best Linuxero",
                LocalDate.now(),
                LocalDate.now().plusDays(10),
                new EmailNotification()
        );

        // Acción & Verificación
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante, LocalDate.now().plusDays(11), fileExporter);
        });

        assertFalse(concurso.estaParticipante(participante));
    }
}
