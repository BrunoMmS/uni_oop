package Exporters;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Models.*;

public class FileExporter implements DataExporter{

    private static final String FILE_PATH = "inscripciones.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void export(Participante p, int idConcurso, LocalDate fechaInscripcion) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String linea = String.format("%s, %d, %d%n",
                        LocalDate.now().format(FORMATTER),
                        p.getId(),
                        idConcurso);
                writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
