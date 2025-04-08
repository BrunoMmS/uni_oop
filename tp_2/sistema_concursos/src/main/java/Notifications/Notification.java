package Notifications;

import Models.Participante;

import java.time.LocalDate;

public interface Notification {
    void send(Participante p, String nombreConcurso, LocalDate fechaInscripcion);
}
