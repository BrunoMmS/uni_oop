import java.io.File;

public abstract class BaseExporter implements IExporter{
    protected IExporter exporter;

    public BaseExporter(IExporter exporter){
        this.exporter = exporter;
    }

    @Override
    public void export(File file){
        this.exporter.export(file);
    }
}
