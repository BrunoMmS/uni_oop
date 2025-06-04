import java.util.ArrayList;
import java.util.List;

public abstract class ItemCompuesto implements IItem{
    private final String name;

    private final List<IItem> itemsDeTrabajo = new ArrayList<>();

    public ItemCompuesto(String name){
        this.name = name;
    }

    public void addItem(IItem item){
        itemsDeTrabajo.add(item);
    }

    @Override
    public String name(){
        return this.name;
    }

    @Override
    public int duracion(){
        return itemsDeTrabajo.stream().mapToInt(IItem::duracion).sum();
    }

}
