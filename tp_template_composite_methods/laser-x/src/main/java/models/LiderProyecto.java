package models;

import commons.EmpleadoComposite;

import java.util.ArrayList;

public class LiderProyecto extends EmpleadoComposite {
    private ArrayList<Empleado> empleadosRegulares;

    public LiderProyecto(String nombre, String apellido, String legajo, double salario) {
        super(nombre, apellido, legajo, salario);
    }
}
