import java.util.ArrayList;
import java.util.List;

class Alfabetizador implements EscuchadorDeDatos {
    private AlmacenLineas origen;
    private List<String> todasLasLineasOrdenadas = new ArrayList<>();

    public Alfabetizador(AlmacenLineas origen) {
        this.origen = origen;
    }

    @Override
    public void reaccionarNuevoCambio() {
        // "Voy a ver": Extrae la rotación que el procesador acaba de gritar
        String nuevaRotacion = origen.obtenerUltima();
        
        // Procesa: Inserción manual para mantener el orden alfabético
        insertarOrdenadamente(nuevaRotacion);
        
        // Muestra el progreso
        imprimirEstadoActual();
    }

    private void insertarOrdenadamente(String nuevaLinea) {
        int i = 0;
        // Buscamos la posición donde nuevaLinea sea menor que la línea en la lista
        while (i < todasLasLineasOrdenadas.size() && 
               nuevaLinea.compareToIgnoreCase(todasLasLineasOrdenadas.get(i)) > 0) {
            i++;
        }
        // Insertamos en el índice encontrado
        todasLasLineasOrdenadas.add(i, nuevaLinea);
    }

    private void imprimirEstadoActual() {
        System.out.println("\n--- Índice KWIC (Ordenado por Inserción) ---");
        for (String l : todasLasLineasOrdenadas) {
            System.out.println(l);
        }
    }
}