import Tarjetas.Tarjeta;
import Tarjetas.TipoPropina;

public class Cobrar {

    public Factura generarFactura(Tarjeta tarjeta, Mesa mesa, TipoPropina propina) {
        var totalBebidas = mesa.cerrarPrecioTotalTipoItem(TypeItem.BEBIDA);
        var totalPlatos = mesa.cerrarPrecioTotalTipoItem(TypeItem.PLATO);
        var totalCena = totalBebidas + totalPlatos;

        var descuento = Math.round(tarjeta.aplicarDescuento(totalBebidas, totalPlatos) * 100.0) / 100.0;
        var totalConDescuento = Math.round((totalCena - descuento) * 100.0) / 100.0;

        var propinaCalculada = Math.round((totalConDescuento * propina.getValor()) * 100.0) / 100.0;
        var total = Math.round((totalConDescuento + propinaCalculada) * 100.0) / 100.0;

        return new Factura(tarjeta, totalCena, propinaCalculada, total, descuento);
    }
}
