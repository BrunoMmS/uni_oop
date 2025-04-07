import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<Item> consumibles;

    public Menu(){
        consumibles = new ArrayList<>();
    }

    public void agregarItem(Item item){
        consumibles.add(item);
    }
    public void sacarItem(Item item){
        consumibles.remove(item);
    }

    public List devolverItems(){
        return consumibles;
    }
}
