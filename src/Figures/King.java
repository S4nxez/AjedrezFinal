package Figures;
import Mecanicas.*;

public class King extends ChessFigure {
    public King(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♚]";//negra
        else
            nameFigure = "[♔]";
    }

    private boolean kingMoved = false;

    public void setKingMoved(boolean kingMoved) {
        this.kingMoved = kingMoved;
    }

    public boolean isKingMoved() {
        return kingMoved;
    }
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
