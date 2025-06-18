public class Papas extends AdicionalDecorator {
    public Papas(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + ", con Papas";
    }

    @Override
    public int costo() {
        return combo.costo() + 250;
    }
}