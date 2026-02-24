 public class KWIC {
    public static void main(String[] args) {
        //se crea el almacen origen y el destino para el rotador
        AlmacenLineas almacenOriginal = new AlmacenLineas();
        AlmacenLineas almacenDestino = new AlmacenLineas();
            
        //se crean los dos modulos, el primero sera subscritor del almacen original y el segundo del destino
        //recibe el almacen original y el destino donde guardara las lineas rotadas
        Rotador rotador = new Rotador(almacenOriginal, almacenDestino);
        //recibe el almacen destino para escuchar las rotaciones y ordenarlas
        Alfabetizador alfabetizador = new Alfabetizador(almacenDestino);

        //el almacen rotador se suscirbe al original (lineas originales)
        almacenOriginal.suscribir(rotador);
        //el alfabetizador se suscribir al almacen destino (lineas que proporciona el rotador)
        almacenDestino.suscribir(alfabetizador);

        //Se crea una instancia de la clase lector y se leen
        LectorArchivo lector = new LectorArchivo(almacenOriginal);
        lector.leer("datos.txt");

        //se crea una instancia de la clase output y se imprimen los resultados
        Output output = new Output(almacenDestino);
        output.imprimir();
    }
} 
    

