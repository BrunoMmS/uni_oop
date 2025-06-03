import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import models.*;

public class TestEmpresa {

    @Test
    public void testDirectorTotal() {
        var director = new Director("Jorge", "Jorge", "123asd", 10000);
        var gerente = new Gerente("Gerente", "Gerente", "1234", 1000);
        var mandoMedio = new MandosMedios("Mando", "Medio", "mandomedio", 100);
        var liderProyecto = new LiderProyecto("Lider", "Proyecto", "lp", 10);
        var empleadoRegular = new Empleado("Empleado", "Regular", "ER", 1);
        var empleadoRegular2 = new Empleado("Empleado2", "Regular2", "ER2", 50);

        director.agregarSubordinado(gerente);
        gerente.agregarSubordinado(mandoMedio);
        mandoMedio.agregarSubordinado(liderProyecto);
        liderProyecto.agregarSubordinado(empleadoRegular);
        liderProyecto.agregarSubordinado(empleadoRegular2);

        double esperado = director.salario() + gerente.salario() + mandoMedio.salario()
                + liderProyecto.salario() + empleadoRegular.salario() + empleadoRegular2.salario();

        assertEquals(esperado, director.salarioTotal());
    }

    @Test
    public void testLiderProyecto(){
        var liderProyecto = new LiderProyecto("Lider", "Proyecto", "lp", 10);
        var empleadoRegular = new Empleado("Empleado", "Regular", "ER", 1);
        var empleadoRegular2 = new Empleado("Empleado2", "Regular2", "ER2", 50);

        liderProyecto.agregarSubordinado(empleadoRegular);
        liderProyecto.agregarSubordinado(empleadoRegular2);

        double esperado = liderProyecto.salario() + empleadoRegular.salario() + empleadoRegular2.salario();

        assertEquals(esperado, liderProyecto.salarioTotal());
    }
}
