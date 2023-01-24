package Figures;

public class Queen extends ChessFigure {
    public Queen(boolean color) {
        super(color);
        if (color)
            nameFigure = "Qn";//reina negra
        else
            nameFigure = "Qb";

    }

    @Override
    public void movement() {
        //Move
    }
}
