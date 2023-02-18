package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;

/**
 * Peon
 * 
 * @author NDJ
 */
public class Pawn extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * 
     * @param color
     */
    public Pawn(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♟]";// negra
        else
            nameFigure = "[♙]";
    }

    /**
     * Método para regular el movimiento del peon
     * 
     * @param mov recibe el movimiento a realizar para ahora verificar si es
     *            correcto
     * @param tb  recibe las posiciones del tablero
     * @return devuelve la validación del movimiento que quería devolver el usuario
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        boolean respuesta = false;
        if (tb.hayPiezaEntre(mov))
            System.out.println("Error, hay una pieza entre medias y no puedes hacer tu movimiento.");
        else if (mov.esDiagonal() && mov.saltoVertical() == 1 && getColor() == true && tb.hayPieza(mov.getendPos()) == true)
            respuesta = true;
        else if (mov.esDiagonal() && mov.saltoVertical() == -1 && getColor() == false && tb.hayPieza(mov.getendPos()) == true)
            respuesta = true;
        else if (mov.saltoVertical() == 1 && getColor() == true  && mov.saltoHorizontal()==0)
            respuesta = true;
        else if ((mov.saltoVertical() == -1 && getColor() == false) && mov.saltoHorizontal()==0)
            respuesta = true;
        else if (mov.getstartPos().getFila() == 1 && getColor() == true && mov.saltoVertical() == 2  && mov.saltoHorizontal()==0)
            respuesta = true;
        else if (mov.getstartPos().getFila() == 6 && getColor() == false && mov.saltoVertical() == -2 && mov.saltoHorizontal()==0)
            respuesta = true;
        else
            respuesta = false;
        return respuesta;
    }
}
