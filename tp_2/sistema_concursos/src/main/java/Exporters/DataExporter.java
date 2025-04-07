package Exporters;
import Models.Concurso;
import Models.Participante;

import java.time.LocalDate;

public interface DataExporter {
    void export(Participante p, int idConcurso, LocalDate fechaInscripcion);
}
