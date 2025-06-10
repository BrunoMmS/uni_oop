import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemeraTest {

    private static final double DELTA = 0.001; 
    @Test
    public void testCalcularPrecioFinalRemeraImportada() {
        double precioUnitario = 100.0;
        Remera remeraImportada = new RemeraImportada(precioUnitario);
        double precioFinal = remeraImportada.calcularPrecioFinal();
        assertEquals(135.0, precioFinal, DELTA);
    }

    @Test
    public void testCalcularPrecioFinalRemeraNacional() {
        double precioUnitario = 80.0;
        Remera remeraNacional = new RemeraNacional(precioUnitario);

        double precioFinal = remeraNacional.calcularPrecioFinal();
        assertEquals(74.704, precioFinal, DELTA);
    }

    @Test
    public void testRemeraImportadaNoAplicaBonificacion() {
        double precioUnitario = 100.0;
        RemeraImportada remeraImportada = new RemeraImportada(precioUnitario);
        double precioConRecargos = remeraImportada.aplicarRecargosEImpuestos(precioUnitario);
        double precioSinBonificacion = remeraImportada.aplicarBonificacion(precioConRecargos);

        assertEquals(precioConRecargos, precioSinBonificacion, DELTA);
    }

    @Test
    public void testRemeraNacionalRecargoTransporte() {
        double precioUnitario = 100.0;
        RemeraNacional remeraNacional = new RemeraNacional(precioUnitario);

        double precioConRecargos = remeraNacional.aplicarRecargosEImpuestos(precioUnitario);
        assertEquals(101.5, precioConRecargos, DELTA);
    }
}