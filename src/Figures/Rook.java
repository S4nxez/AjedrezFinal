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


    private boolean rookMoved = false;

    public void setRookMoved(boolean rookMoved) {
        this.rookMoved = rookMoved;
    }

    public boolean isRookMoved() {
        return rookMoved;
    }

    public boolean movement(Movement mov, Tablero tb) {
        return mov.esHorizontal()|| mov.esVertical();
    }
}