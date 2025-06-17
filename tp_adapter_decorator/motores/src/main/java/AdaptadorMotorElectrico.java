class AdaptadorMotorElectrico implements Motor {
    private MotorElectrico motorElectrico;

    public AdaptadorMotorElectrico() {
        this.motorElectrico = new MotorElectrico();
    }

    public void arrancar() {
        motorElectrico.conectar();
        motorElectrico.activar();
    }

    public void acelerar() {
        motorElectrico.moverMasRapido();
    }

    public void apagar() {
        motorElectrico.detener();
        motorElectrico.desconectar();
    }
}
