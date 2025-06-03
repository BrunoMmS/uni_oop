public class Tarea implements IItemTrabajo{
    private String nombre;
    private int duracion;

    public Tarea(String nombre, int duracion){
        this.nombre = nombre;
        this.duracion = duracion;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getDuracion() {
        return duracion;
    }
}
