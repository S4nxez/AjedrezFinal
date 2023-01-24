package Figures;

public class Queen extends ChessFigure {
    public Queen(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♛]";//reina negra
        else
            nameFigure = "[♕]";
    }

    @Override
    public void movement() {
        //Move
    }
}
