import java.util.ArrayList;
import java.util.List;

class Alfabetizador implements EscuchadorDeDatos {
    private AlmacenLineas origen;
    private List<String> todasLasLineasOrdenadas = new ArrayList<>();

    public Alfabetizador(AlmacenLineas origen) {
        this.origen = origen;
    }
//en el almacen de la clase rotador, se grita y este al escuchar responde con:
    @Override
    public void reaccionarNuevoCambio() {
        //extraigo la ultima linea recibida en ese momento
        String nuevaRotacion = origen.obtenerUltima();
        
        //se llama al metodo
        insertarOrdenadamente(nuevaRotacion);
        
        // Muestra el progreso
        imprimirEstadoActual();
    }

    private void insertarOrdenadamente(String nuevaLinea) {
        //iniciamos el indice en 0
        int i = 0;
        //mientras que la lista sea mayor a 0 y la nueva linea sea mayor a la anterior en orden alfabenico se incrmeenta el indice, cuando este se supere sale de while
        while (i < todasLasLineasOrdenadas.size() && 
               nuevaLinea.compareToIgnoreCase(todasLasLineasOrdenadas.get(i)) > 0) {
            i++;
        }
        // se inserta la nueva linea, por ejemplo si fue mayor, al no incrementar el indice al inicio, si incrementa, pues despues de i elemento
        todasLasLineasOrdenadas.add(i, nuevaLinea);
    }

    private void imprimirEstadoActual() {
        System.out.println("Índice KWIC ACTUAL:\n");
        for (String l : todasLasLineasOrdenadas) {
            System.out.println(l);
        }
    }
}