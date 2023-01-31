package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;

public class Rook extends ChessFigure {
    public Rook(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♜]";//negra
        else
            nameFigure = "[♖]";
    }


    public boolean movement(Movement mov, Tablero tb) {
        return mov.esHorizontal()|| mov.esVertical();
    }
}