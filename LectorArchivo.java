import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {
    private AlmacenLineas almacen;

    public LectorArchivo(AlmacenLineas almacen) {
        this.almacen = almacen;
    }
//recibe la ruta del archivo y lo separa en lineas para mandarselo al almacen mientras las lineas no sean vacias
    public void leer(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    almacen.agregarLineaNotificando(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
