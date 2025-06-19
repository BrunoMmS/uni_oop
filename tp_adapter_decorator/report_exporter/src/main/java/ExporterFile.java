import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExporterFile implements IExporter{
    private String contenido;

    public ExporterFile(String contenido){
        this.contenido = contenido;
    }

    @Override
    public void export(File file) {
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(file, false));  //false (sobrescribir) // true (append)
            salida.println(this.contenido);
            salida.close();
            System.out.println("Se registró correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
