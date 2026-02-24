import java.util.ArrayList;
import java.util.List;

class Alfabetizador implements EscuchadorDeDatos {
    private AlmacenLineas origen;

    public Alfabetizador(AlmacenLineas origen) {
        this.origen = origen;
    }
//en el almacen de la clase rotador, se grita y este al escuchar responde con:
    @Override
    public void reaccionarNuevoCambio() {
        if (origen.size() == 0) return;
    
        int idxNueva = origen.size() - 1;     //la rotación recién insertada
        String nueva = origen.get(idxNueva);
    
        int pos = 0;
        while (pos < idxNueva && nueva.compareToIgnoreCase(origen.get(pos)) > 0) {
            pos++;
        }
    
        if (pos == idxNueva) return; //ya estaba en lugar correcto
    
        //mover dentro del MISMO store, sin notificar (para evitar loops)
        origen.eliminarEnSilencio(idxNueva);
        origen.insertarEnSilencio(pos, nueva);
    }
}
