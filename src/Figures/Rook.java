package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;

/**
 * Torre
 * @author NDJ
 */
public class Rook extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public Rook(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♜]";//negra
        else
            nameFigure = "[♖]";
    }
    private boolean rookMoved = false;

    /**
     * Setter del estado de la torre
     * @param rookMoved
     */
    public void setRookMoved(boolean rookMoved) {
        this.rookMoved = rookMoved;
    }

    /**
     * Getter del estado de la torre
     * @return
     */
    public boolean isRookMoved() {
        return rookMoved;
    }


    /**
     * Método para regular el movimiento de la torre
     * @param mov
     * @param tb
     * @return
     */
    public boolean movement(Movement mov, Tablero tb) {
        return mov.esHorizontal()|| mov.esVertical();
    }
}