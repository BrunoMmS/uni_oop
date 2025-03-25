package Tarjetas;

public class ComarcaPlus implements TarjetaCobro {
    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float)((totalBebidas + totalPlatos) * 0.02);
    }
}
