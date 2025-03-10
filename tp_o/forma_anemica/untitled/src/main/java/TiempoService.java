import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TiempoService {

    public  String obtenerTiempoFormatoLargo(Tiempo fecha){
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));
        return fecha.getFecha().format(formatoLargo);
    }
    public String obtenerTiempoFormatoCorto(Tiempo fecha){
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.getFecha().format(formatoCorto);
    }
}
