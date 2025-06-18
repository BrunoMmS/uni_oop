public abstract class AdicionalDecorator implements Combo {
    protected Combo combo;

    public AdicionalDecorator(Combo combo) {
        this.combo = combo;
    }

    public abstract String descripcion();
    public abstract int costo();
}