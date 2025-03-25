public enum TipoPropina {
    BAJA(0.02),
    MEDIA(0.03),
    ALTA(0.05);
    private float valor;
    TipoPropina(double v) {
        this.valor = (float) v;
    }
    public float getValor(){
        return valor;
    }
}
