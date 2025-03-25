package Tarjetas;

public class Mastercard implements TarjetaCobro {
    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float) (totalBebidas + (totalPlatos * 0.02));
    }
}
