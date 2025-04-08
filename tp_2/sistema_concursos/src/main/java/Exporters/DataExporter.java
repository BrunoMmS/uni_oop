package Exporters;
import Models.Concurso;
import Models.Participante;

import java.time.LocalDate;
import java.util.UUID;

public interface DataExporter {
    void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion);
}
