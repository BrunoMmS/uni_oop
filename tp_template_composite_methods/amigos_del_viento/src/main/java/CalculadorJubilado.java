import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorJubilado extends CalculadorTemplate {
    public CalculadorJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    protected double porcentajeAdicional() {
        if (!of(mesEnPromocion).equals(now().getMonth())) {
            return 0.10;
        }
        return 0.0;
    }
}