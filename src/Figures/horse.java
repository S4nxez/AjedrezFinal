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
        return (mov.saltoVertical()==1 && mov.saltoHorizontal() == 2 || mov.saltoHorizontal() == 2 && mov.saltoVertical() == 1);
    }
}
