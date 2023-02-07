package Figures;
import Mecanicas.*;

/**
 * Alfíl
 * @author NDJ
 */
public class Bishop extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public Bishop(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♝]";//negra
        else
            nameFigure = "[♗]";
    }

    @Override
    public boolean movement(Movement mov, Tablero tb){
        return mov.esDiagonal();
        }
}



