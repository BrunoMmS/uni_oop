import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHamburguesas {

    @Test
    public void TestHamburguesaFamiliar(){
        var combo = new ComboBuilder().iniciarCon(new ComboEspecial()).agregarCarne().agregarPapas().construir();

        assertEquals(5150, combo.costo());
    }

    @Test
    public void TestHamburguesaBasica(){
        var combo = new ComboBuilder().iniciarCon(new ComboBasico()).agregarCarne().agregarTomate()
                    .agregarPapas().construir();

        assertEquals(2750, combo.costo());
    }
}
