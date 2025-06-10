import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Month;

public class CalculadorTest {

    @Test
    public void testCalculadorJubiladoFueraDePromocion() {
        LogMock log = new LogMock();
        int mesPromo = Month.JANUARY.getValue();
        Calculador calc = new CalculadorJubilado(log, mesPromo);

        double precio = 100.0;
        double esperado = 110.0;

        assertEquals(esperado, calc.calcularPrecio(precio), 0.001);
        assertTrue(log.logs.contains(CalculadorJubilado.class.getName()));
    }

    @Test
    public void testCalculadorNoJubiladoEnPromocion() {
        LogMock log = new LogMock();
        int mesActual = java.time.LocalDate.now().getMonthValue();
        Calculador calc = new CalculadorNoJubilado(log, mesActual);

        double precio = 100.0;
        double esperado = 115.0;

        assertEquals(esperado, calc.calcularPrecio(precio), 0.001);
        assertTrue(log.logs.contains(CalculadorNoJubilado.class.getName()));
    }
}
