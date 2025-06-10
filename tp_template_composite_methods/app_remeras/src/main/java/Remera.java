public abstract class Remera {
    private double precioUnitario;

    public Remera(double precioUnitario){
        this.precioUnitario = precioUnitario;
    }

    public final double calcularPrecioFinal() {
        double precioConRecargos = aplicarRecargosEImpuestos(precioUnitario);
        double precioConBonificacion = aplicarBonificacion(precioConRecargos);
        return aplicarMargenComercial(precioConBonificacion);
    }

    protected abstract double aplicarRecargosEImpuestos(double precioUnitario);
    protected abstract double aplicarBonificacion(double precioDespuesDeCargos);
    protected abstract double aplicarMargenComercial(double precioDespuesDeBonificacion);
}
