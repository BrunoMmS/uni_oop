package Fakes;

import Exporters.DataExporter;
import Models.Participante;

import java.time.LocalDate;
import java.util.UUID;

public class FakeExporter implements DataExporter {
    public boolean wasExported = false;

    @Override
    public void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion) {
        wasExported = true;
    }
}
