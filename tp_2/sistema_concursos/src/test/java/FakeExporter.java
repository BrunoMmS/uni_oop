import Exporters.DataExporter;
import Models.Participante;

import java.time.LocalDate;
import java.util.UUID;

public class FakeExporter implements DataExporter {
    @Override
    public void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion) {

    }
}
