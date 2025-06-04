import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProyecto {

    @Test
    public void TestProyectoSolo(){
        var proyecto = new Proyecto("Test Proyecto Solo");

        assertEquals(0, proyecto.duracion());
    }

    @Test
    public void TestProyectoConHistUsuario(){
        var proyecto = new Proyecto("Test Proyecto Solo");
        var historia = new HistoriaUsuario("Hacer algo");

        proyecto.addItem(historia);
        assertEquals(0, proyecto.duracion());
    }

    @Test
    public void TestProyectoConTareas(){
        var proyecto = new Proyecto("Test Proyecto Solo");
        var historia = new HistoriaUsuario("Hacer algo");
        var tarea1 = new Tarea("hacer algo", 4, "mover algo");
        var spike = new Spike("Nota: 1", 5, "Cambiar dependencias");

        historia.addItem(tarea1);
        proyecto.addItem(historia);
        proyecto.addItem(spike);

        assertEquals(9, proyecto.duracion());
    }

    @Test
    public void TestProyectoConSoloSpikes(){
        var proyecto = new Proyecto("Test Proyecto Solo");

        var spike = new Spike("Nota: 1", 10, "Cambiar dependencias");
        var spike2 = new Spike("Nota: 12", 8, "Cambiar algo");

        proyecto.addItem(spike);
        proyecto.addItem(spike2);

        assertEquals(18, proyecto.duracion());
    }
}
