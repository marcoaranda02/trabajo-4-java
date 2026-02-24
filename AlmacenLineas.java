import java.util.ArrayList;
import java.util.List;

public class AlmacenLineas {
    //el almacen tiene un arreglo de lineas, así como un arreglo de interesados
        private List<String> lineas = new ArrayList<>();
        private List<EscuchadorDeDatos> interesados = new ArrayList<>();
    //el metodo suscribirse recibiria objetos que compartan la interfaz comun escuchadorDeDatos y serán agregados a la lista
        public void suscribir(EscuchadorDeDatos modulo) {
            interesados.add(modulo);
        }
    //agrega una al almacen y se le "grita" que ha habido cambios y que los interesados deben reaccionar
        public void agregarLineaNotificando(String linea) {
            lineas.add(linea);
            // Aquí es donde "grita"
            for (EscuchadorDeDatos e : interesados) {
                e.reaccionarNuevoCambio(); 
            }
        }
    //  obtiene la ultima linea agregada, que es la que se le indica a los interesados
        public String obtenerUltima() {
            return lineas.get(lineas.size() - 1);
        }

        public int size() {
            return lineas.size();
        }
        
        public String get(int i) {
            return lineas.get(i);
        }
        
        public void insertarEnSilencio(int i, String linea) {
            lineas.add(i, linea);
        }
        
        public String eliminarEnSilencio(int i) {
            return lineas.remove(i);
}

    
}