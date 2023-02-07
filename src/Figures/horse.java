package Figures;
import Mecanicas.*;

/**
 * Caballo
 * @author NDJ
 */
public class Horse extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public Horse(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♞]";//negra
        else
            nameFigure = "[♘]";//blanca
    }

    /**
     * Método para regular el movimiento del caballo
     * @param mov
     * @param tb
     * @return
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {

        if  ((Math.abs(mov.saltoHorizontal()) == 1 && Math.abs(mov.saltoVertical()) == 2) ||(
            Math.abs(mov.saltoHorizontal()) == 2 && Math.abs(mov.saltoVertical()) == 1)) {
            return true;

        } else {return false;}
    }

}
