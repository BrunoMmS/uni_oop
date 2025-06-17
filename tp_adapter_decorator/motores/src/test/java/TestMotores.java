package motores;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMotores {

    @Test
    public void testMotorComun() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        Motor motor = new MotorComun();
        motor.arrancar();
        motor.acelerar();
        motor.apagar();

        String esperado = String.join("\n",
            "Se arranco el auto",
            "Se acelero el auto",
            "Se apago el motor el auto"
        );

        assertEquals(esperado, salida.toString().trim().replaceAll("\r\n", "\n"));
    }

    @Test
    public void testMotorEconomico() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        Motor motor = new MotorEconomico();
        motor.arrancar();
        motor.acelerar();
        motor.apagar();

        String esperado = String.join("\n",
            "Motor económico arrancando con bajo consumo",
            "Motor económico acelerando eficientemente",
            "Motor económico apagando para ahorrar energía"
        );

        assertEquals(esperado, salida.toString().trim().replaceAll("\r\n", "\n"));
    }

    @Test
    public void testAdaptadorMotorElectrico() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        Motor motor = new AdaptadorMotorElectrico();
        motor.arrancar();
        motor.acelerar();
        motor.apagar();

        String esperado = String.join("\n",
            "Conectando motor electrico",
            "Activando motor electrico",
            "Motor electrico aumentando velocidad",
            "Deteniendo motor electrico",
            "Desconectando motor electrico"
        );

        assertEquals(esperado, salida.toString().trim().replaceAll("\r\n", "\n"));
    }
}
