package Figures;
import Mecanicas.*;

/**
 * Rey
 * @author NDJ
 */
public class King extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public King(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♚]";//negra
        else
            nameFigure = "[♔]";
    }


    // Variable para saber si el rey ha sido movido (Requerido para el jaque)
    private boolean kingMoved = false;

    /**
     * Setter del estado del rey
     * @param kingMoved
     */
    public void setKingMoved(boolean kingMoved) {
        this.kingMoved = kingMoved;
    }

    /**
     * Getter del estado del rey
     * @return
     */
    public boolean isKingMoved() {
        return kingMoved;
    }

    /**
     * Método para regular el movimiento del rey
     * @param mov
     * @param tb
     * @return
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        if (mov.esDiagonal()&&(Math.abs(mov.saltoVertical()) + Math.abs(mov.saltoHorizontal()) == 2 ))
            return true;
        else if (Math.abs(mov.saltoHorizontal())==1 && mov.esHorizontal())
            return true;
        else if (Math.abs(mov.saltoVertical())==1 && mov.esVertical())
            return true;
        else return false;
    }
}
