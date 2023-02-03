package Mecanicas;

/**
 * Posicion
 * @author NDJ
 */
public class Position {
    private int fila;
    private int columna;

    /**
     *Constructor de la posición
     * @param fila
     * @param columna
     */
    public Position(int fila, int columna){
        this.fila =fila;
        this.columna = columna;
    }

    /**
     *Setter de la fila
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *Setter de la columna
     * @param columna
     */
    public void setColumna(int columna){
        this.columna = columna;
    }

    /**
     *Getter de la fila
     * @return
     */
    public int getFila() {
       return fila;
    }

    /**
     *Getter de la columna
     * @return
     */
    public int getColumna() {
       return columna;
    }

    /**
     *ToString para devolver la posición
     * @return
     */
    @Override
    public String toString() {
       return String.valueOf(fila + columna);
    }
}
