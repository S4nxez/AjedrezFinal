package Figures;

public class Bishop extends ChessFigure {
    public Bishop(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♝]";//negra
        else
            nameFigure = "[♗]";
    }

    @Override
    public void movement() {
        //Move
    }
}
