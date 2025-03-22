import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void test_1(){
        //setup
        var participante = new Participante("Maximiliano", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.of(2025, 3, 31));

        //ejercitacion
        concurso.inscribirParticipante(participante, LocalDate.of(2025, 3, 23 ));

        //
        assertTrue(concurso.estaParticipante(participante));
    }

    @Test
    public void test_2(){
        //setup
        var participante = new Participante("Maximiliano", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.of(2025, 3, 31));

        //ejercitacion
        concurso.inscribirParticipante(participante, LocalDate.now());

        //
        assertTrue(concurso.estaParticipante(participante));
        assertEquals(10, participante.getPoints());
    }
    @Test
    public void test_3() {
        // Setup
        var participante = new Participante("Maximiliano", "Sosa", "123456");
        var concurso = new Concurso("Best Linuxero", LocalDate.now(), LocalDate.of(2025, 3, 31));

        // Ejercitación
        try{
            concurso.inscribirParticipante(participante, LocalDate.of(2025, 4, 1));
        } catch (RuntimeException e) {}

        //
        assertFalse(concurso.estaParticipante(participante));
    }
}
