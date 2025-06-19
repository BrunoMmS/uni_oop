import java.io.File;

public class Reporte {
    private String reporte;
    private IExporter exporter;

    public Reporte(String reporte, IExporter exporter) {
        this.reporte = reporte;
        this.exporter = exporter;
    }

    void export(File file) {
        this.exporter.export(file);
    }
}