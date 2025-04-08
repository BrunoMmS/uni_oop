import Exporters.DatabaseExporter;
import Exporters.EmailExporter;
import Exporters.FileExporter;
import JDBC.ConcursoJDBC;
import Models.Concurso;
import Models.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void testFileExporter(){
        //setup
        var fileExporter = new FileExporter();
        var participante = new Participante("Maximiliano", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.now().plusDays(10));
        //ejercitacion
        concurso.inscribirParticipante(participante, LocalDate.now().plusDays(3), fileExporter);

        //
        assertTrue(concurso.estaParticipante(participante));
    }

    @Test
    public void testDatabaseExporter(){
        //setup
        var databaseExporter = new DatabaseExporter();
        var participante = new Participante("Maximiliano", "Sosa", "12345456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.now().plusDays(10));
        ConcursoJDBC.crear(concurso);

        //ejercitacion
        concurso.inscribirParticipante(participante, LocalDate.now(), databaseExporter);

        //
        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
    }
    @Test
    public void testEmailExporter(){
        //setup
        var databaseExporter = new EmailExporter();
        var participante = new Participante("Maximiliano", "Sosa", "12345456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.now().plusDays(10));
        ConcursoJDBC.crear(concurso);

        //ejercitacion
        concurso.inscribirParticipante(participante, LocalDate.now(), databaseExporter);

        //
        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
    }
    @Test
    public void test_3() {
        // Setup
        var fileExporter = new FileExporter();

        var participante = new Participante("Maximiliano", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.now().plusDays(10));

        // Ejercitación
        try{
            concurso.inscribirParticipante(participante, LocalDate.now().plusDays(11), fileExporter);
        } catch (RuntimeException e) {}

        //
        assertFalse(concurso.estaParticipante(participante));
    }
}
