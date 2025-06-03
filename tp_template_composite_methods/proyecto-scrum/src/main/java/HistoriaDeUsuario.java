import java.util.ArrayList;
import java.util.List;

public class HistoriaDeUsuario implements IItemTrabajo{
    private String nombre;
    private List<IItemTrabajo> items = new ArrayList<>();
    private String tipoItem; //Una referencia burda

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getDuracion() {
        return  items.stream().mapToInt(IItemTrabajo::getDuracion).sum();
    }
}
