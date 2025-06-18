public class Carne extends AdicionalDecorator {
    public Carne(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + ", con Carne";
    }

    @Override
    public int costo() {
        return combo.costo() + 400;
    }
}