package Fakes;

import Notifications.Notification;
import Models.Participante;

import java.time.LocalDate;

public class FakeNotification implements Notification {
    public boolean wasNotified = false;
    public Participante notifiedParticipant;
    public String notifiedConcurso;
    public LocalDate notifiedFecha;

    @Override
    public void send(Participante p, String nameConcurso, LocalDate fechaInscripcion) {
        wasNotified = true;
        notifiedParticipant = p;
        notifiedConcurso = nameConcurso;
        notifiedFecha = fechaInscripcion;
    }
}
