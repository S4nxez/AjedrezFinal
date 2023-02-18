package Figures;

import Mecanicas.Movement;
import Mecanicas.Tablero;

/**
 * Figura llamada Torre
 * @author NDJ
 */
public class Rook extends ChessFigure {

    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color define el color de la ficha
     */
    public Rook(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♜]";//negra
        else
            nameFigure = "[♖]";
    }


    /**
     * Método para regular el movimiento de la torre
     * @param mov
     * @param tb
     * @return
     */
    public boolean movement(Movement mov, Tablero tb) {
        boolean respuesta=false;
        if (!tb.hayPiezaEntre(mov))
            return mov.esHorizontal() || mov.esVertical();
        else{
            System.out.println("Error, hay una pieza entre medias y no puedes hacer tu movimiento.");
            tb.setNomaserrores(true);
            return respuesta;
        }
    }
}