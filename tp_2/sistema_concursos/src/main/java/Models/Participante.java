package Models;

import java.util.Objects;
import java.util.UUID;

public class  Participante {
    private int id;
    private String name;
    private String lastName;
    private int points;
    private String dni;
    private UUID idConcurso;

    public Participante(String name, String lastName, String dni){
        this.name = name;
        this.lastName = lastName;
        this.dni  = dni;
        points = 0;
    }
    public Participante(int id, UUID idConcurso, String name, String lastName, String dni){
        this.id = id;
        this.idConcurso = idConcurso;
        this.name = name;
        this.lastName = lastName;
        this.dni  = dni;
        points = 0;
    }
    public void addPoints(int points){
        this.points += points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante that)) return false;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getPoints(){
        return points;
    }
    public int getId(){
        return id;
    }
    public UUID getIdConcurso(){
        return idConcurso;
    }
    public void setConcurso(UUID idConcurso){
        this.idConcurso = idConcurso;
    }

    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getDni(){
        return dni;
    }
}
