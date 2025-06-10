import java.util.ArrayList;
import java.util.List;

public class LogMock implements LogTransaction {
    public List<String> logs = new ArrayList<>();

    @Override
    public void log(String nombreClase) {
        logs.add(nombreClase);
    }
}
