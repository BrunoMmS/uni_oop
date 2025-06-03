package commons;

import java.util.ArrayList;
import java.util.List;

public abstract class EmpleadoComposite extends BaseEmpleado{
    protected List<IEmpleado> subordinados = new ArrayList<>();

    public EmpleadoComposite(String nombre, String apellido, String legajo, double salario) {
        super(nombre, apellido, legajo, salario);
    }

    public void agregarSubordinado(IEmpleado empleado) {
        subordinados.add(empleado);
    }

    @Override
    public double salarioTotal() {
        double total = salario();
        for (IEmpleado e : subordinados) {
            total += e.salarioTotal();
        }
        return total;
    }
}
