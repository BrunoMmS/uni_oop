import java.util.ArrayList;
import java.util.List;

public class PaqueteDeSeguro implements ISeguro{
    private String nombre;
    private List<ISeguro> seguros = new ArrayList<>();

    public PaqueteDeSeguro(String nombre){
        this.nombre = nombre;
    }
    @Override
    public double obtenerCosto() {
        double costo = 0;
        int cantSeguros = 0;
        for(ISeguro s : seguros){
            costo += s.obtenerCosto();
            cantSeguros++;
        }
        double descuento = 1 - (cantSeguros * 0.05);
        if (descuento < 0) descuento = 0;
        return costo * descuento;
    }

    public void añadirNuevoSeguro(ISeguro seguro){
        seguros.add(seguro);
    }
}
