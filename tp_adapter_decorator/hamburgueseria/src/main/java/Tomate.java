public class Tomate extends AdicionalDecorator {
    public Tomate(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + ", con Tomate";
    }

    @Override
    public int costo() {
        return combo.costo() + 100;
    }
}