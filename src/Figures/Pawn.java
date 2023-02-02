package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;

public class Pawn extends ChessFigure {
    public Pawn(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♟]";//negra
        else
            nameFigure = "[♙]";
    }

    /*Condiciones que debe cumplir el peon:
    -Si está en su posición inicial puede mover hasta 2 en vertical
    -Si hay cambio de fila de valor 1 el movimiento es vertical
    -Si come ficha se mueve 1 en diagonal
    -Ningún movimiento puede ir hacia atras
    -Un peon puede promocionar a cualquier pieza menos peón, independientemente de
    si excede el número inicial. Ej: 2 damas es válido*/

    /* Hay que añadir la condicion de que haya */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        if (mov.esDiagonal() && mov.saltoVertical()==1 && getColor() == true && tb.hayPieza(mov.getendPos()) == true)
            return mov.esDiagonal();
        else if (mov.esDiagonal() && mov.saltoVertical()==-1 && getColor() == false && tb.hayPieza(mov.getendPos()) == true)
            return mov.esDiagonal();
        else if (mov.saltoVertical() == 1 && getColor() == true)
            return mov.esVertical();
        else if ((mov.saltoVertical() == -1 && getColor() == false))
            return mov.esVertical();
        else if (mov.getstartPos().getFila() == 1 && getColor() == true && mov.saltoVertical() == 2 )
                return mov.esVertical();
        else if (mov.getstartPos().getFila() == 6 && getColor() == false && mov.saltoVertical() == -2)
            return mov.esVertical();
        else
            return false;

    }
}
