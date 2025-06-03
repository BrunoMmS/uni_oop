import models.*;

public class Main {
    public static void main(String[] args) {
        var director = new Director("Jorge", "Jorge", "123asd", 10000);
        var gerente = new Gerente("Gerente", "Gerente", "1234", 1000);
        var mandoMedio = new MandosMedios("Mando", "Medio", "mandomedio", 100);
        var liderProyecto = new LiderProyecto("Lider", "Proyecto", "lp", 10);
        var empleadoRegular = new Empleado("Empleado", "Regular", "ER", 1);
        var empleadoRegular2 = new Empleado("Empleado2", "Regular2", "ER", 50);

        director.agregarSubordinado(gerente);
        gerente.agregarSubordinado(mandoMedio);
        mandoMedio.agregarSubordinado(liderProyecto);
        liderProyecto.agregarSubordinado(empleadoRegular);
        liderProyecto.agregarSubordinado(empleadoRegular2);

        System.out.println("Salario total desde director: " + director.salarioTotal());
        System.out.println("Salario total desde gerente: " + gerente.salarioTotal());
        System.out.println("Salario total desde mandoMedio: " + mandoMedio.salarioTotal());
        System.out.println("Salario total desde LiderProyecto: " + liderProyecto.salarioTotal());
        System.out.println("Salario total desde empleadoRegular: " + empleadoRegular.salarioTotal());

    }
}