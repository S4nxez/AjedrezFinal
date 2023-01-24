package Figures;

public class King extends ChessFigure {
    public King(boolean color) {
        super( color);
        if (color)
            nameFigure = "[♚]";//negra
        else
            nameFigure = "[♔]";
    }

    @Override
    public void movement() {
        //Move
    }
}
