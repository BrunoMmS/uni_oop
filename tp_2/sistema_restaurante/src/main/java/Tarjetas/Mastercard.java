package Tarjetas;

public class Mastercard implements Tarjeta {
    private String nroTarjeta;
    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float) (totalPlatos * 0.02);
    }
    public Mastercard(String nroTarjeta){
        this.nroTarjeta = nroTarjeta;
    }
}
