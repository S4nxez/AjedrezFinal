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

    @Override
    public boolean movement(Movement mov, Tablero tb) {
        if (mov.esDiagonal()&&(Math.abs(mov.saltoVertical()) + Math.abs(mov.saltoHorizontal()) == 2 ))
            return mov.esDiagonal();
        else if (Math.abs(mov.saltoHorizontal())==1)
            return mov.esHorizontal();
        else if (mov.saltoVertical()==1)
            return mov.esVertical();
        else return false;
    }
}
