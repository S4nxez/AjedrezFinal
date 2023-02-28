package Figures;
import Mecanicas.*;

/**
 * Alfil
 * @author NDJ
 */
public class Bishop extends ChessFigure {
    /**
     * Metodo para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public Bishop(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♝]";//negra
        else
            nameFigure = "[♗]";
    }
    /**
     * Sobreescrivimos el metodo de movimiento del padre
     */
    @Override
    public boolean movement(Movement mov, Tablero tb){
        return mov.esDiagonal();
        }
}



