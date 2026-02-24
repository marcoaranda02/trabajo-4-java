import java.util.ArrayList;
import java.util.Arrays;

class  Rotador implements EscuchadorDeDatos {
    private AlmacenLineas origen;
    private AlmacenLineas destino;

    public Rotador(AlmacenLineas o, AlmacenLineas d) {
        this.origen = o;
        this.destino = d;
    }

    @Override
    public void reaccionarNuevoCambio() {
        // 1. "Voy a ver": El componente reacciona y extrae el dato más reciente [cite: 511]
        String linea = origen.obtenerUltima();
        System.out.println("Procesador: Recibí la línea, generando rotaciones...");
        
        // 2. Procesa el dato
        generarRotaciones(linea);
    }

    private void generarRotaciones(String linea) {
        // Dividimos la línea en palabras (limpiando espacios extra)
        String[] palabrasArray = linea.trim().split("\\s+");
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList(palabrasArray));

        // El sistema KWIC requiere todas las rotaciones circulares de la línea 
        for (int i = 0; i < palabras.size(); i++) {
            // Unimos las palabras actuales para formar una línea rotada
            String lineaRotada = String.join(" ", palabras);
            
            // 3. "Mando al almacén": Al agregarla al destino, este almacén "gritará" [cite: 512]
            destino.agregarLinea(lineaRotada);
            
            // Rotamos circularmente: quitamos la primera palabra y la ponemos al final 
            String primera = palabras.remove(0);
            palabras.add(primera);
        }
    }
}