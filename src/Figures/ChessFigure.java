package Figures;
import Mecanicas.*;

public abstract class ChessFigure {
    private boolean color; /* TRUE = NEGRAS ; FALSE = BLANCAS */
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

