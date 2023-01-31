package Figures;
import Mecanicas.*;

public class Bishop extends ChessFigure {
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



