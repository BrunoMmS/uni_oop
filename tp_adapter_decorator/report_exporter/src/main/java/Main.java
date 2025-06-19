import java.io.File;

public class Main {
    public static void main(String[] args) {
        String rutaValidado = "src/main/java/archivos/archivo_no_validado.txt";
        File fileValidado = new File(rutaValidado);

        IExporter exportConValidacion = new ExporterBuilder()
                .conContenido("Mensaje con validacion")
                .conValidacion()
                .build();

        var reporte1 = new Reporte("Reporte de Validacion", exportConValidacion);
        reporte1.export(fileValidado);


        String rutaNoValidado = "src/main/java/archivos/archivo_no_validado.txt";
        File fileNoValidado = new File(rutaNoValidado);

        IExporter exportSinValidacion = new ExporterBuilder()
                .conContenido("Mensaje sin validación.")
                .build();

        var reporte2 = new Reporte("Reporte sin validacion", exportSinValidacion);
        reporte2.export(fileNoValidado);
    }
}
