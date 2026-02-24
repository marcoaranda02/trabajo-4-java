import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {
    private AlmacenLineas almacen;

    public LectorArchivo(AlmacenLineas almacen) {
        this.almacen = almacen;
    }

    public void leer(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    // Al agregar la línea, el almacén notificará automáticamente
                    // a todos los "escuchadores" registrados.
                    almacen.agregarLinea(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}