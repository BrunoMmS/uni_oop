public class ExporterBuilder {
    private boolean conValidacion = false;
    private String contenido;

    public ExporterBuilder conContenido(String contenido) {
        this.contenido = contenido;
        return this;
    }

    public ExporterBuilder conValidacion() {
        this.conValidacion = true;
        return this;
    }

    public IExporter build() {
        if (contenido == null) {
            throw new IllegalStateException("No se puede construir un exportador sin contenido.");
        }

        IExporter exporter = new ExporterFile(contenido);

        if (conValidacion) {
            exporter = new ExporterWithValidation(exporter);
        } else {
            exporter = new ExporterWithoutValidation(exporter);
        }

        return exporter;
    }
}
