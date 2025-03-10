import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        fecha = LocalDate.now();
    }

    public  String obtenerTiempoFormatoLargo(){
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
        return fecha.format(formatoLargo);
    }
    public String obtenerTiempoFormatoCorto(){
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatoCorto);
    }

    /*
    En esta implementacion "No Anemica", donde encapsulamos el objeto y evitamos el uso de getters y setters que hacen que rompan el principio
    de encapsulamiento. En lugar de exponer directamente los atributos, permitimos que el propio objeto determine su comportamiento ante las llamadas,
    como por ejemplo formatear y devolver la fecha en distintos formatos.
    */
}
