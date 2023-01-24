package Figures;

public class Rook extends ChessFigure {
    public Rook(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♜]";//negra
        else
            nameFigure = "[♖]";
    }

    @Override
    public void movement() {
        //Move
    }
}
