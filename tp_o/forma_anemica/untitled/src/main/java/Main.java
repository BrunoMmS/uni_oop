public class Main {

    public static void main(String[] args) {
        var service_tiempo = new TiempoService();
        var fecha = new Tiempo();

        System.out.println(service_tiempo.obtenerTiempoFormatoLargo(fecha));
        System.out.println(service_tiempo.obtenerTiempoFormatoCorto(fecha));

        /*
            En esta implementacion "Anemica" usamos como "contenedor" de datos el objeto "Tiempo"
            Rompemos su encapsulamiento exponiendo sus datos a traves de getters y setters, y tambien delegamos el comportamiento de formato
            al objeto "TiempoService".
            De esta forma  "Tiempo" solamente queda como un portador de datos, sin logica de negocios, ni comportamiento, ni responsabilidad
         */
    }
}
