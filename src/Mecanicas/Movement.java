package Mecanicas;

/**
 *Movimiento
 * @author NDJ
 */
public class Movement {
    private Position startPos;
    private Position endPos;

    /**
     *Constructor del movimiento con posición inicial y posición final
     * @param startPos
     * @param endPos
     */
    public Movement(Position startPos, Position endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    /**
     *Construsctor del movimiento con posición inicial y posición final
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
     *Método para saber si el movimiento es vertical
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
     *Método para saber si el movimiento
     * @return
     */
    public boolean esHorizontal() {
       boolean respuesta = false;
        if (startPos.getFila() == endPos.getFila())
            respuesta = true;
        return respuesta;
    }

    /**
     *
     * @return
     */
    public boolean esDiagonal() {
        return Math.abs(saltoVertical()) == Math.abs(saltoHorizontal());
    }

    /**
     *
     * @return
     */

    public Position getstartPos(){return startPos;}

    /**
     *
     * @return
     */
    public Position getendPos(){return endPos;}

    /**
     *
     * @return
     */

    public int saltoVertical() {
        return (endPos.getFila() - startPos.getFila());
    }

    /**
     *
     * @return
     */
    public int saltoHorizontal() {
        return endPos.getColumna() - startPos.getColumna();
    }
}
