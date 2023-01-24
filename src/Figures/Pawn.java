package Figures;

public class Pawn extends ChessFigure {
    public Pawn(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♟]";//negra
        else
            nameFigure = "[♙]";
    }

    @Override
    public void movement() {
        //Move
    }
}
