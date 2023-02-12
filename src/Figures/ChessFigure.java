package Figures;
import Mecanicas.*;

/**
 * Figura
 * @author NDJ
 */
public abstract class ChessFigure {
    private boolean color; /* TRUE = NEGRAS ; FALSE = BLANCAS */
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
    
    public String getNameFigure() {
        return nameFigure;
        /*
            ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜
            ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟
            ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙
            ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖
        * */
    }


    public abstract boolean movement(Movement mov, Tablero tb);
        /*if(tb.devuelvePieza(mov.getstartPos().getFila(),mov.getstartPos().getColumna())== Bishop) Bishop.movement(mov);
        else if(tb.devuelvePieza(i,j)== Horse)
        else if(tb.devuelvePieza(i,j)== King)
        else if(tb.devuelvePieza(i,j)== Pawn)
        else if(tb.devuelvePieza(i,j)== Queen)
        else // seria rook

        }
  */

}

