package Exporters;

import Models.Participante;

import java.time.LocalDate;
import java.util.UUID;

public class EmailExporter implements DataExporter {
    @Override
    public void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion) {
        
    }
}
