import java.time.LocalDate;
import java.util.Locale;

public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

}
