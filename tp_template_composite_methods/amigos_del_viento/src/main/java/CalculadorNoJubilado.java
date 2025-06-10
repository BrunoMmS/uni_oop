import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorNoJubilado extends CalculadorTemplate {
    public CalculadorNoJubilado(LogTransaction log, int mesEnPromocion) {
        super(log, mesEnPromocion);
    }

    @Override
    protected double porcentajeAdicional() {
        if (of(mesEnPromocion).equals(now().getMonth())) {
            return 0.15;
        }
        return 0.21;
    }
}

