package Tarjetas;

public class VisaCobro implements TarjetaCobro {

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float) (totalPlatos + (totalBebidas * 0.03));
    }
}
