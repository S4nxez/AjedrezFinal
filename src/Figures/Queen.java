package Figures;

import Mecanicas.*;

public class Queen extends ChessFigure {
    public Queen(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♛]";//reina negra
        else
            nameFigure = "[♕]";
    }

    @Override
    public boolean movement(Movement mov, Tablero tb) {
        return mov.esDiagonal() || mov.esHorizontal() || mov.esVertical();

    }
}


