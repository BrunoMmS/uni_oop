package Tarjetas;

public class Visa implements Tarjeta {
    private  String nroTarjeta;
    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float) (totalBebidas * 0.03);
    }
    public Visa(String nroTarjeta){
        this.nroTarjeta = nroTarjeta;
    }
}
