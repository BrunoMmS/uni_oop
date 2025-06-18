public class ComboBuilder {
    private Combo combo;

    public ComboBuilder iniciarCon(Combo comboBase) {
        this.combo = comboBase;
        return this;
    }

    public ComboBuilder agregarTomate() {
        this.combo = new Tomate(this.combo);
        return this;
    }

    public ComboBuilder agregarQueso() {
        this.combo = new Queso(this.combo);
        return this;
    }

    public ComboBuilder agregarPapas() {
        this.combo = new Papas(this.combo);
        return this;
    }

    public ComboBuilder agregarCarne() {
        this.combo = new Carne(this.combo);
        return this;
    }

    public Combo construir() {
        return this.combo;
    }
}
