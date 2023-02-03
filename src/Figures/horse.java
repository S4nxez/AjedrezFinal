package Figures;
import Mecanicas.*;

public class Horse extends ChessFigure {
    public Horse(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♞]";//negra
        else
            nameFigure = "[♘]";//blanca
    }

    @Override
    public boolean movement(Movement mov, Tablero tb) {
        
        if  (Math.abs(mov.saltoHorizontal()) == 1 && Math.abs(mov.saltoVertical()) == 2 ||
            Math.abs(mov.saltoHorizontal()) == 2 && Math.abs(mov.saltoVertical()) == 1) {
            return true;

        } else {return false;}
    }
}
