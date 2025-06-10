import static java.time.LocalDate.now;
import static java.time.Month.of;

public abstract class CalculadorTemplate implements Calculador {
    protected LogTransaction log;
    protected int mesEnPromocion;

    public CalculadorTemplate(LogTransaction log, int mesEnPromocion) {
        this.log = log;
        this.mesEnPromocion = mesEnPromocion;
    }

    @Override
    public double calcularPrecio(double precioProducto) {
        double precioFinal = precioProducto + (precioProducto * porcentajeAdicional());
        log.log(this.getClass().getName());
        return precioFinal;
    }

    protected abstract double porcentajeAdicional();
}
