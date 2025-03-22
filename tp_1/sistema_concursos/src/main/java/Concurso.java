import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private static int id;
    private String nombre;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Participante> participantes;

    public Concurso(String nombre, LocalDate startDate, LocalDate endDate){
        this.id += 1;
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

        return true;
    }

    public boolean estaParticipante(Participante participante){
        return participantes.stream().anyMatch(p -> p.equals(participante));
    }
}
