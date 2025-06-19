import java.io.File;

public class ExporterWithoutValidation extends BaseExporter{
    public ExporterWithoutValidation(IExporter exporter) {
        super(exporter);
    }

    @Override
    public void export(File file){
        super.export(file);
    }
}
