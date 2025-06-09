import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSeguros {

    @Test
    public void TestPaqueteSeguro(){
        var seguroMedico = new Seguro(3.5, TipoSeguro.MEDICO);
        var seguroAutomovil = new Seguro(4, TipoSeguro.AUTOMOVIL);
        var seguroVida = new Seguro(10, TipoSeguro.VIDA);
        var miPaquete = new PaqueteDeSeguro("Seguro contra todo Riesgo");

        miPaquete.añadirNuevoSeguro(seguroMedico);
        miPaquete.añadirNuevoSeguro(seguroAutomovil);
        miPaquete.añadirNuevoSeguro(seguroVida);

        assertEquals(14.875, miPaquete.obtenerCosto(), 0.001);
    }

    @Test
    public void TestPaqueteSeguroFamilia(){
        var paqueteFamiliar = new PaqueteDeSeguro("Familiar");

        var paqueteHijo_1 = new PaqueteDeSeguro("Hijo 1");
        var paqueteHijo_2 = new PaqueteDeSeguro("Hijo 2");
        var paqueteHijo_3 = new PaqueteDeSeguro("Hijo 3");

        var seguroVida = new Seguro(8, TipoSeguro.VIDA);
        var seguroMedico = new Seguro(10, TipoSeguro.MEDICO);

        paqueteHijo_1.añadirNuevoSeguro(seguroVida);
        paqueteHijo_1.añadirNuevoSeguro(seguroMedico);

        paqueteHijo_2.añadirNuevoSeguro(seguroVida);
        paqueteHijo_2.añadirNuevoSeguro(seguroMedico);

        paqueteHijo_3.añadirNuevoSeguro(seguroVida);
        paqueteHijo_3.añadirNuevoSeguro(seguroMedico);

        paqueteFamiliar.añadirNuevoSeguro(paqueteHijo_1);
        paqueteFamiliar.añadirNuevoSeguro(paqueteHijo_2);
        paqueteFamiliar.añadirNuevoSeguro(paqueteHijo_3);

        assertEquals(41.31, paqueteFamiliar.obtenerCosto(), 0.001);
    }
}
