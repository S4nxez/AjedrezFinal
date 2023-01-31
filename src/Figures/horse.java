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
        
        if (mov.saltoHorizontal()==1 && mov.saltoVertical()==2 ||
            mov.saltoHorizontal()==2 && mov.saltoVertical()==1 ||
            mov.saltoHorizontal()==-1 && mov.saltoVertical()==-2 ||
            mov.saltoHorizontal()==-2 && mov.saltoVertical()==-1 ){
            return (mov.saltoVertical()==1 && mov.saltoHorizontal() == 2 || mov.saltoHorizontal() == 2 && mov.saltoVertical() == 1);
        }
        else return false;
    }
}
