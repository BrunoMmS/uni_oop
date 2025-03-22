import java.util.Objects;

public class Participante {
    private String name;
    private String lastName;
    private int points;
    private String dni;

    public Participante(String name, String lastName, String dni){
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
}
