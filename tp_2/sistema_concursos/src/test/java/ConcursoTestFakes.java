import Fakes.FakeExporter;
import Fakes.FakeNotification;
import Models.Concurso;
import Models.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTestFakes {

    @Test
    public void testExporterGuardaParticipante(){
        var fakeExporter = new FakeExporter();
        var fakeNotification = new FakeNotification();
        var participante = new Participante("Julio", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.now().plusDays(10), fakeNotification);

        concurso.inscribirParticipante(participante, LocalDate.now().plusDays(3), fakeExporter);

        assertTrue(concurso.estaParticipante(participante));
        assertTrue(fakeExporter.wasExported);
        assertTrue(fakeNotification.wasNotified);
    }

    @Test
    public void testPuntosOtorgados(){
        var fakeExporter = new FakeExporter();
        var fakeNotification = new FakeNotification();
        var participante = new Participante("Maximiliano", "Sosa", "12345456");
        var concurso = new Concurso("Concurso de Prueba", LocalDate.now(), LocalDate.now().plusDays(10), fakeNotification);

        concurso.inscribirParticipante(participante, LocalDate.now(), fakeExporter);

        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
        assertTrue(fakeExporter.wasExported);
        assertTrue(fakeNotification.wasNotified);
    }

    @Test
    public void testNotificacionAlInscribir(){
        var fakeExporter = new FakeExporter();
        var fakeNotification = new FakeNotification();
        var participante = new Participante("Maria", "Gomez", "789456");
        var concurso = new Concurso("Concurso de Diseño", LocalDate.now(), LocalDate.now().plusDays(5), fakeNotification);

        concurso.inscribirParticipante(participante, LocalDate.now().plusDays(1), fakeExporter);

        assertTrue(fakeNotification.wasNotified);
        assertEquals(participante, fakeNotification.notifiedParticipant);
        assertEquals("Concurso de Diseño", fakeNotification.notifiedConcurso);
    }

    @Test
    public void testParticipanteFueraDeFechaNoSeInscribe(){
        var fakeExporter = new FakeExporter();
        var fakeNotification = new FakeNotification();
        var participante = new Participante("Ana", "Perez", "987654");
        var concurso = new Concurso("Concurso Cerrado", LocalDate.now(), LocalDate.now().plusDays(5), fakeNotification);

        try {
            concurso.inscribirParticipante(participante, LocalDate.now().plusDays(10), fakeExporter);
        } catch (RuntimeException e) {

        }

        assertFalse(concurso.estaParticipante(participante));
        assertFalse(fakeExporter.wasExported);
        assertFalse(fakeNotification.wasNotified);
    }
}
