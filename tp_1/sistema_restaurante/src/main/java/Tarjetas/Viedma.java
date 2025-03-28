package Tarjetas;

public class Viedma implements Tarjeta{
    private String nroTarjeta;
    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return 0;
    }
    public Viedma(String nroTarjeta){
        this.nroTarjeta = nroTarjeta;
    }
}
