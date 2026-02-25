import java.util.ArrayList;
import java.util.Arrays;

class  Rotador implements EscuchadorDeDatos {
    //poosee 2 almacenes, el de entrada que son los datos previos a rotar
    private AlmacenLineas origen;
    //otro almacen que son los elementos ya rotados que se "gritaran"
    private AlmacenLineas destino;

    public Rotador(AlmacenLineas o, AlmacenLineas d) {
        this.origen = o;
        this.destino = d;
    }


    //cuando el almacen principal llame a que reaccione, este respondera con:
    @Override
    public void reaccionarNuevoCambio() {
        //obtendra la linea más "reciente" del almacen original para procesarla
        String linea = origen.obtenerUltima();
        System.out.println("Rotando..."+linea);
        

    
        //preocesa la rotación
        generarRotaciones(linea);
    }


    private void generarRotaciones(String linea) {
        //separa el String en palabras y las guarda por separado utilizando una función regex que busca los espacios en blanco
        String[] palabrasArray = linea.trim().split("\\s+");
        //se convierte en un arryalist para manipular más fácil
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList(palabrasArray));


if(validarRepetidas(palabras)){
        //se genera n cantidad de rotaciones, dependiendo la cantidad de palabras en el arreglo
        for (int i = 0; i < palabras.size(); i++) {
            //Se captura la rotación actual y se une el arrelglo con espacios en blanco
            String lineaRotada = String.join(" ", palabras);
            
           //se le dice al "segundo" almacen que se a hecho una rotación para que este le grite a los nuevos interesados
           //dentro de agregar linea que es un metodo de almacen, "grita" a los interesados de ese almacen
            destino.agregarLineaNotificando(lineaRotada);
            
            //se toma la primera palabra y se manda al final
            String primera = palabras.remove(0);
            palabras.add(primera);
        }
        }
        else {
            destino.agregarLineaNotificando(linea);
        }
    }


private boolean validarRepetidas(ArrayList<String> palabras) {
    //si solo es una palabra
    if ( palabras.size() <= 1) {
        return false; 
    }
//se obtiene la primera palabra del arreglo
    String primera = palabras.get(0);
    for (int i = 1; i < palabras.size(); i++) {
        ///si se encuentra alguna palabra diferente a la primera
        if (!primera.equals(palabras.get(i))) {
            return true; 
        }
    }
    
    //salimos del ciclo
    return false; 
}
}