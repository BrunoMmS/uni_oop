package models;

import commons.EmpleadoComposite;

public class Gerente extends EmpleadoComposite {
    public Gerente(String nombre, String apellido, String legajo, double salario) {
        super(nombre, apellido, legajo, salario);
    }
}
