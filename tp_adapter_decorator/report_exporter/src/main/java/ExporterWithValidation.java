import java.io.File;

public class ExporterWithValidation extends BaseExporter{

    public ExporterWithValidation(IExporter exporter) {
        super(exporter);
    }

    @Override
    public void export(File file){
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        if (file.exists()) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }
        super.export(file);
    }
}
