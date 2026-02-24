//implements EscuchadorDeDatos

class Output{
    private AlmacenLineas lines;

    public Output(AlmacenLineas lines) {
        this.lines = lines;
    }

    //@Override
    //public void reaccionarNuevoCambio() {
    //    imprimir(); // imprime cada vez que cambie
    //}

    public void imprimir() {
        System.out.println("===== ÍNDICE KWIC =====\n");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
        System.out.println("------------------------------\n");
    }
}
