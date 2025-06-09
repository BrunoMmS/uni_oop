public class Main {
    public static void main(String[] args) {
        var seguroMedico = new Seguro(3.5, TipoSeguro.MEDICO);
        var seguroAutomovil = new Seguro(4, TipoSeguro.AUTOMOVIL);
        var seguroVida = new Seguro(10, TipoSeguro.VIDA);
        var miPaquete = new PaqueteDeSeguro("Seguro contra todo Riesgo");

        miPaquete.añadirNuevoSeguro(seguroMedico);
        miPaquete.añadirNuevoSeguro(seguroAutomovil);
        miPaquete.añadirNuevoSeguro(seguroVida);

        System.out.println(miPaquete.obtenerCosto());


    }
}