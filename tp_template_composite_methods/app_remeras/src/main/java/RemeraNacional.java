public class RemeraNacional extends  Remera{

    public RemeraNacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double aplicarRecargosEImpuestos(double basePrice) {
        double costoTransporte = basePrice * 0.015;
        return basePrice + costoTransporte;
    }

    @Override
    protected double aplicarBonificacion(double priceAfterCharges) {
        return priceAfterCharges * 0.80;
    }

    @Override
    protected double aplicarMargenComercial(double priceAfterBonification) {
        return priceAfterBonification * 1.15;
    }
}
