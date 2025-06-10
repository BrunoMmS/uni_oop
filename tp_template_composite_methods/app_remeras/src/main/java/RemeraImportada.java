public class RemeraImportada extends Remera{

    public RemeraImportada(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double aplicarRecargosEImpuestos(double precioUnitario) {
        double RECARGO = 0.03;
        double IMPUESTO_ADUANERO = 0.05;

        double recargo = precioUnitario * RECARGO;
        double impuestoAduanero = precioUnitario * IMPUESTO_ADUANERO;

        return precioUnitario + recargo + impuestoAduanero;
    }

    @Override
    protected double aplicarBonificacion(double precioDespuesDeCargos) {
        return precioDespuesDeCargos;
    }

    @Override
    protected double aplicarMargenComercial(double precioDespuesDeBonificacion) {
        double MARGEN_COMERCIAL = 1.25;

        return precioDespuesDeBonificacion * MARGEN_COMERCIAL;
    }
}
