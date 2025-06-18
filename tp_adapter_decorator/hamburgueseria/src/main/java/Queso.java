public class Queso extends AdicionalDecorator {
    public Queso(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + ", con Queso";
    }

    @Override
    public int costo() {
        return combo.costo() + 200;
    }
}