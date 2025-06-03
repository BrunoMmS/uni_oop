import Tarjetas.Tarjeta;

public class Factura {
    private Tarjeta tarjetaUsada;
    private double montoDeCena;
    private double propina;
    private double totalAPagar;
    private double descuento;
    public Factura (Tarjeta tarjetaUsada, double montoDeCena, double propina, double totalAPagar, double descuento){
        this.tarjetaUsada = tarjetaUsada;
        this.montoDeCena = montoDeCena;
        this.propina = propina;
        this.descuento = descuento;
        this.totalAPagar = totalAPagar;
    }

    public double getMontoDeCena(){
        return montoDeCena;
    }
    public double getPropina(){
        return propina;
    }
    public double descuento(){
        return descuento + propina;
    }
    public double getTotalAPagar(){
        return totalAPagar;
    }

}
