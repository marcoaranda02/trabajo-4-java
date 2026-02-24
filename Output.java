class Output {
    private AlmacenLineas lines;

    public Output(AlmacenLineas lines) {
        this.lines = lines;
    }

    public void imprimir() {
        System.out.println("===== ÍNDICE KWIC (ALFABETIZADO) =====\n");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
