package Mecanicas;

/**
 *Movimiento
 * @author NDJ
 */
public class Movement {
    private Position startPos;
    private Position endPos;

    /**
<<<<<<< HEAD
     *Constructor del movimiento con posición inicial y posición final
=======
     *Constructor del movimiento con posicion final e inicial
>>>>>>> 0f9b289b1b7ddab6416a69076c48758d2fb08647
     * @param startPos
     * @param endPos
     */
    public Movement(Position startPos, Position endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    /**
<<<<<<< HEAD
     *Construsctor del movimiento con posición inicial y posición final
=======
     *Constructor del movimiento con filas y columnas al inicio y final del movimiento
>>>>>>> 0f9b289b1b7ddab6416a69076c48758d2fb08647
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
<<<<<<< HEAD
     *Método para saber si el movimiento es vertical
=======
     *Método para comprabar si un movimiento es vertical
>>>>>>> 0f9b289b1b7ddab6416a69076c48758d2fb08647
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
<<<<<<< HEAD
     *Método para saber si el movimiento
=======
     *Método para comprobar si un movimiento es horizontal
>>>>>>> 0f9b289b1b7ddab6416a69076c48758d2fb08647
     * @return
     */
    public boolean esHorizontal() {
       boolean respuesta = false;
        if (startPos.getFila() == endPos.getFila())
            respuesta = true;
        return respuesta;
    }

    /**
     *Método para comprobar si un movimiento es diagonal
     * @return
     */
    public boolean esDiagonal() {
        return Math.abs(saltoVertical()) == Math.abs(saltoHorizontal());
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
}
