public abstract class Item implements IItem{
    private final String name;
    private final int duration;
    private final String descripcion;

    public Item(String name, int duration, String descripcion) {
        this.name = name;
        this.duration = duration;
        this.descripcion = descripcion;
    }

    @Override
    public String name(){
        return name;
    }

    @Override
    public int duracion(){
        return duration;
    }
}
