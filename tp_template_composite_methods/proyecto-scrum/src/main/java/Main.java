public class Main {
    public static void main(String[] args) {
        var proyecto = new Proyecto("Proyecto");
        var historia = new HistoriaUsuario("Clave");
        var tarea = new Tarea("Masa", 10, "Harina, agua y sal");
        var spike = new Spike("Nota 1", 3, "asd");

        historia.addItem(tarea);
        proyecto.addItem(historia);
        proyecto.addItem(spike);

        System.out.println("Nombre: " + proyecto.name());
        System.out.println("Duración total: " + proyecto.duracion());
    }
}