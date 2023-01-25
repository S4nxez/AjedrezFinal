package Figures;

public class Horse extends ChessFigure {
    public Horse(boolean color) {
        super( color);
        if (color)
            nameFigure = "[♞]";//negra
        else
            nameFigure = "[♘]";
    }

    @Override
    public void movement() {
        //Move
    }

}
