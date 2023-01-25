public class Position {
    private int fila;
    private int columna;

   public Position(int fila, int columna){
        this.fila =fila;
        this.columna = columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }

    public int getFila() {return fila;
    }

    public int getColumna() {return columna;
    }
    @Override
    public String toString() {
       return String.valueOf(fila + columna);
    }
}
