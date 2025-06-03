package Tarjetas;

public class ComarcaPlus implements Tarjeta {
    private String nroTarjeta;

    @Override
    public float aplicarDescuento(float totalBebidas, float totalPlatos) {
        return (float)((totalBebidas + totalPlatos) * 0.02);
    }
    public ComarcaPlus(String nroTarjeta){
        this.nroTarjeta = nroTarjeta;
    }
}
