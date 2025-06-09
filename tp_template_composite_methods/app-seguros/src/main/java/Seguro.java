//Se puede volver clase abstracta y con polimorfismo especificar cada
//tipo de seguro por si hay que extender funcionalidades especificas
//para cada tipo de seguro.
public class Seguro implements ISeguro{
    private TipoSeguro tipoSeguro;
    private double costo;

    public Seguro(double costo, TipoSeguro tipoSeguro){
        this.costo = costo;
        this.tipoSeguro = tipoSeguro;
    }

    @Override
    public double obtenerCosto() {
        return costo;
    }
}
