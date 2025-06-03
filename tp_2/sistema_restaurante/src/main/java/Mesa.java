import java.util.ArrayList;

public class Mesa {
    private int id;
    private boolean ocupado;
    private ArrayList<Item> itemsPedidos;


    public Mesa(int id, boolean ocupado){
        this.id = id;
        this.ocupado = ocupado;
        this.itemsPedidos = new ArrayList<>();
    }

    public void agregarItems(Item item){
        this.itemsPedidos.add(item);
    }

    public float cerrar(){
        float totalDeMesa = 0;

        for(Item i : itemsPedidos){
            totalDeMesa += i.getPrice();
        }

        return totalDeMesa;
    }
    public float cerrarPrecioTotalTipoItem(TypeItem tipoItem){
        float precioItems = 0;
        for(Item i : itemsPedidos){
            if(i.verTipo() == tipoItem){
                precioItems += i.getPrice();
            }
        }
        return precioItems;
    }
}
