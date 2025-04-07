import Tarjetas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPagos {

    @Test
    public void VisaTest(){
        //SETUP
        var cobrador = new Cobrar();

        var coca = new Item("Coca cola", (float)15.0, TypeItem.BEBIDA);
        var pepsi = new Item("Pepsi", (float)10.0, TypeItem.BEBIDA);

        var milanesa = new Item("Milanesa con fritas", (float)25.0, TypeItem.PLATO);
        var pastelPapa = new Item("Pastel de papas", (float)35.0, TypeItem.PLATO);

        var tarjeta = new Visa("123456789");
        var mesa = new Mesa(1, true);

        //ejercitacion
        mesa.agregarItems(coca);
        mesa.agregarItems(milanesa);
        var factura = cobrador.generarFactura(tarjeta, mesa, TipoPropina.BAJA);

        assertEquals(40, factura.getMontoDeCena());
        assertEquals( 40.34,factura.getTotalAPagar());
    }
    @Test
    public void MastercardTest(){
        //SETUP
        var cobrador = new Cobrar();

        var coca = new Item("Coca cola", (float)15.0, TypeItem.BEBIDA);
        var pepsi = new Item("Pepsi", (float)10.0, TypeItem.BEBIDA);

        var milanesa = new Item("Milanesa con fritas", (float)25.0, TypeItem.PLATO);
        var pastelPapa = new Item("Pastel de papas", (float)35.0, TypeItem.PLATO);

        var tarjeta = new Mastercard("123456789");
        var mesa = new Mesa(1, true);

        //ejercitacion
        mesa.agregarItems(coca);
        mesa.agregarItems(milanesa);
        var factura = cobrador.generarFactura(tarjeta, mesa, TipoPropina.BAJA);

        assertEquals(40, factura.getMontoDeCena());
        assertEquals( 40.29,factura.getTotalAPagar());
    }
    @Test
    public void ComarcaPlusTest(){
        //SETUP
        var cobrador = new Cobrar();

        var coca = new Item("Coca cola", (float)15.0, TypeItem.BEBIDA);
        var pepsi = new Item("Pepsi", (float)10.0, TypeItem.BEBIDA);

        var milanesa = new Item("Milanesa con fritas", (float)25.0, TypeItem.PLATO);
        var pastelPapa = new Item("Pastel de papas", (float)35.0, TypeItem.PLATO);

        var tarjeta = new ComarcaPlus("123456789");
        var mesa = new Mesa(1, true);

        //ejercitacion
        mesa.agregarItems(coca);
        mesa.agregarItems(milanesa);
        var factura = cobrador.generarFactura(tarjeta, mesa, TipoPropina.BAJA);

        assertEquals(40, factura.getMontoDeCena());
        assertEquals( 39.98,factura.getTotalAPagar());
    }
    @Test
    public void ViedmaTest(){
        //SETUP
        var cobrador = new Cobrar();

        var coca = new Item("Coca cola", (float)15.0, TypeItem.BEBIDA);
        var pepsi = new Item("Pepsi", (float)10.0, TypeItem.BEBIDA);

        var milanesa = new Item("Milanesa con fritas", (float)25.0, TypeItem.PLATO);
        var pastelPapa = new Item("Pastel de papas", (float)35.0, TypeItem.PLATO);

        var tarjeta = new Viedma("123456789");
        var mesa = new Mesa(1, true);

        //ejercitacion
        mesa.agregarItems(coca);
        mesa.agregarItems(milanesa);
        var factura = cobrador.generarFactura(tarjeta, mesa, TipoPropina.BAJA);

        assertEquals(40, factura.getMontoDeCena());
        assertEquals( 40.8,factura.getTotalAPagar());
    }
}
