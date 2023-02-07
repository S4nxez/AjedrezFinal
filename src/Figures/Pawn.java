package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;
 /**
  * Peon
  * @author NDJ
  */
public class Pawn extends ChessFigure {
     /**
      * Método para definir el color de la ficha y asignarle su apariencia
      * @param color
      */
    public Pawn(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♟]";//negra
        else
            nameFigure = "[♙]";
    }

     /**
      * Método para regular el movimiento del peon
      * @param mov
      * @param tb
      * @return
      */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        if (mov.esDiagonal() && mov.saltoVertical()==1 && getColor() == true && tb.hayPieza(mov.getendPos()) == true)
            return true;
        else if (mov.esDiagonal() && mov.saltoVertical()==-1 && getColor() == false && tb.hayPieza(mov.getendPos()) == true)
            return true;
        else if (mov.saltoVertical() == 1 && getColor() == true)
            return true;
        else if ((mov.saltoVertical() == -1 && getColor() == false))
            return true;
        else if (mov.getstartPos().getFila() == 1 && getColor() == true && mov.saltoVertical() == 2 )
                return true;
        else if (mov.getstartPos().getFila() == 6 && getColor() == false && mov.saltoVertical() == -2)
            return true;
        else
            return false;

    }
}
