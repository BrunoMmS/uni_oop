package Exporters;

import JDBC.ParticipanteJDBC;
import Models.Participante;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.UUID;

public class DatabaseExporter implements DataExporter {
    @Override
    public void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion) {
        p.setConcurso(idConcurso);
        ParticipanteJDBC.crear(p);
    }
}
