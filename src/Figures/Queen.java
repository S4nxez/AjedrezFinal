package Figures;

import Mecanicas.*;

/**
 * Reina
 * @author NDJ
 */
public class Queen extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public Queen(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♛]";//reina negra
        else
            nameFigure = "[♕]";
    }

    /**
     * Método para regular el movimiento de la reina
     * @param mov
     * @param tb
     * @return
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        return mov.esDiagonal() || mov.esHorizontal() || mov.esVertical();

    }
}


