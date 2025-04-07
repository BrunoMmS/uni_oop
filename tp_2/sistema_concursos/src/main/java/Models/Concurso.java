package Models;

import Exporters.DataExporter;
import Exporters.FileExporter;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private DataExporter exporter;
    private static int idCounter;
    private final int id;
    private final String nombre;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private ArrayList<Participante> participantes;

    public Concurso(String nombre, LocalDate startDate, LocalDate endDate){
        this.id = ++idCounter;
        this.nombre = nombre;
        this.startDate = startDate;
        this.endDate = endDate;
        participantes = new ArrayList<>();
    }
    public boolean inscribirParticipante(Participante unParticipante, LocalDate fechaInscripcion){
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
        return true;
    }

    public boolean estaParticipante(Participante participante){
        return participantes.stream().anyMatch(p -> p.equals(participante));
    }

    public ArrayList<Participante> getParticipantes(){
        return participantes;
    }
    public int getId(){
        return id;
    }
}
