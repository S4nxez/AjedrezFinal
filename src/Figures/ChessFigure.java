package Figures;
import Mecanicas.*;

/**
 * Figura
 * @author NDJ
 */
public abstract class ChessFigure {
    private boolean color; /* TRUE = NEGRAS ; FALSE = BLANCAS */
    public abstract boolean movement(Movement mov, Tablero tb);
    protected String nameFigure;

    /**
     * Setter del color y el nombre de la figura
     * @param nameFigure
     * @param color
     */
    public ChessFigure (String nameFigure, boolean color) {
        this.color = color;
        this.nameFigure = nameFigure;
    }

    /**
     * Setter del color de la figura
     * @param color
     */
    public ChessFigure(boolean color) { //¿Esto porque hace falta?
        this.color = color;
    }

    /**
     * Getter del color de la figura
     * @return
     */
    public boolean getColor() {
        return this.color;
    }

    /**
     * Getter del nombre de la figura
     * @param fila
     * @param columna
     * @return
     */
    public String getNameFigure(int fila, int columna) {
        return nameFigure;
        /*
            ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜
            ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟
            ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙
            ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖
        * */
    }
    
    
    /** 
     * @return String
     */
    public String getNameFigure() {
        return nameFigure;
        /*
            ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜
            ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟
            ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙
            ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖
        * */
    }
}

