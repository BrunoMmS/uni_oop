package models;

import commons.EmpleadoComposite;

public class Director extends EmpleadoComposite {
    public Director(String nombre, String apellido, String legajo, double salario) {
        super(nombre, apellido, legajo, salario);
    }
}
