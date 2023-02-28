package Mecanicas;

/**
 * Clase Movimiento
 */
public class Movement {
    private Position startPos;
    private Position endPos;

    /**
     *Constructor del movimiento con posicion final e inicial
     * @param startPos
     * @param endPos
     */
    public Movement(Position startPos, Position endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    /**
     *Constructor del movimiento con filas y columnas al inicio y final del movimiento
     * @param filaInicial
     * @param columnaInicial
     * @param filaFinal
     * @param columnaFinal
     */
    public Movement(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        startPos = new Position(filaInicial, columnaInicial);
        endPos = new Position(filaFinal, columnaFinal);
    }

    /**
     *Método para comprabar si un movimiento es vertical
     * @return
     */
    public boolean esVertical() {
        boolean respuesta = false;
        if (startPos.getColumna() == endPos.getColumna())
            respuesta = true;
        return respuesta;
        //return startPos.getColumna()==endPos.getColumna();
    }

    /**
     *Método para comprobar si un movimiento es horizontal
     * @return
     */
    public boolean esHorizontal() {
       boolean respuesta = false;
        if (startPos.getFila() == endPos.getFila())
            respuesta = true;
        return respuesta;
    }
    /**
     *Getter de la posición inicial
     * @return
     */

    public Position getstartPos(){return startPos;}

    /**
     *Getter de la posición final
     * @return
     */
    public Position getendPos(){return endPos;}

    /**
     *Método para saber si un moviemiento es un salto vertical
     * @return
     */

    public int saltoVertical() {
        return (endPos.getFila() - startPos.getFila());
    }

    /**
     *Método para saber si un movimiento es un salto horizontal
     * @return
     */
    public int saltoHorizontal() {
        return endPos.getColumna() - startPos.getColumna();
    }

    /**
     *Método para comprobar si un movimiento es diagonal
     * @return
     */
    public boolean esDiagonal() {
        boolean respuesta = false;
        if (Math.abs(saltoVertical()) == Math.abs(saltoHorizontal()))
            respuesta=true;
        return respuesta;
    }


}
