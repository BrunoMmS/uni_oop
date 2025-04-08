package Models;

import Exporters.DataExporter;
import Exporters.FileExporter;
import Notifications.Notification;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Concurso {
    private UUID id;
    private final String nombre;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private ArrayList<Participante> participantes;
    private Notification systemNotification;

    public Concurso(String nombre, LocalDate startDate, LocalDate endDate, Notification systemNotification) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participantes = new ArrayList<>();
        this.systemNotification = systemNotification;
    }
    public Concurso(UUID id, String nombre, LocalDate startDate, LocalDate endDate){
        this.id = id;
        this.nombre = nombre;
        this.startDate = startDate;
        this.endDate = endDate;
        participantes = new ArrayList<>();
    }
    public boolean inscribirParticipante(Participante unParticipante, LocalDate fechaInscripcion, DataExporter exporter){
        if( fechaInscripcion.isAfter(endDate)){
            throw new RuntimeException("El concurso ha finalizado");
        }
        if(estaParticipante(unParticipante)){
            throw new RuntimeException("El participante ya esta inscripto");
        }
        if(fechaInscripcion.isEqual(startDate)){
            unParticipante.addPoints(10);
        }
        participantes.add(unParticipante);
        exporter.export(unParticipante, id, fechaInscripcion);
        systemNotification.send(unParticipante, this.nombre, fechaInscripcion);
        return true;
    }

    public boolean estaParticipante(Participante participante){
        return participantes.stream().anyMatch(p -> p.equals(participante));
    }

    public ArrayList<Participante> getParticipantes(){
        return participantes;
    }
    public UUID getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }
}
