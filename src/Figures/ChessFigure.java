package Figures;

public abstract class ChessFigure {
    private boolean color;
    protected String nameFigure;

    public ChessFigure (String nameFigure, boolean color) {
        this.color = color;
        this.nameFigure = nameFigure;
    }

    public ChessFigure(boolean color) {
        this.color = color;
    }

    public boolean getColor() {
        return this.color;
    }
    
    public String getNameFigure() {
        return nameFigure;
        /*
            ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜
            ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟
            ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙
            ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖
        * */
    }

    public abstract void movement();

}

