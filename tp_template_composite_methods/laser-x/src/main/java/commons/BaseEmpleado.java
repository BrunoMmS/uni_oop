package commons;

public abstract class BaseEmpleado implements IEmpleado{
    private String nombre;
    private String apellido;
    private String legajo;
    private double salario;

    public BaseEmpleado(String nombre, String apellido, String legajo, double salario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.salario = salario;
    }

    @Override
    public double salario() {
        return this.salario;
    }

    @Override
    public double salarioTotal() {
        return salario();
    }

}
