package Figures;
import Mecanicas.*;

/**
 * Rey
 * @author NDJ
 */
public class King extends ChessFigure {
    /**
     * Método para definir el color de la ficha y asignarle su apariencia
     * @param color
     */
    public King(boolean color) {
        super(color);
        if (color)
            nameFigure = "[♚]";//negra
        else
            nameFigure = "[♔]";
    }


    // Variable para saber si el rey ha sido movido (Requerido para el jaque)
    private boolean kingMoved = false;

    /**
     * Setter del estado del rey
     * @param kingMoved
     */
    public void setKingMoved(boolean kingMoved) {
        this.kingMoved = kingMoved;
    }

    /**
     * Getter del estado del rey
     * @return
     */
    public boolean isKingMoved() {
        return kingMoved;
    }

    /**
     * Método para regular el movimiento del rey
     * @param mov
     * @param tb
     * @return
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        if (mov.esDiagonal()&&(Math.abs(mov.saltoVertical()) + Math.abs(mov.saltoHorizontal()) == 2 ))
            return true;
        else if (Math.abs(mov.saltoVertical())==1 && mov.esVertical())
            return true;
        else if (mov.esHorizontal()){
            if (Math.abs(mov.saltoHorizontal())==1)
                return true;
            if(mov.saltoHorizontal()==2 || mov.saltoHorizontal()==-3){
                isKingMoved();
                if (getColor()==true && tb.deteccionEnroque(mov).charAt(5)==0 /*si el rey negro no se ha movido de su posicion inicial*/){
                    if (mov.saltoHorizontal()==-3){
                        //activas un metodo EN TABLERO para que quite la torre izquierda y la ponga una a la derecha del rey (efectuando enrroque(){quitarpieza(torreizquierda);tableroFichas[posicion derecha del rey] = new Rook(true);})
                    }
                    if (mov.saltoHorizontal()==2){
                        //activas un metodo EN TABLERO para que quite la torre derecha y la ponga una a la derecha del rey "" "" ""
                    }
                }
                if (getColor()==false && tb.deteccionEnroque(mov).charAt(6)==0 /*si el rey blanco no se ha movido de su posicion inicial*/){
                    if (mov.saltoHorizontal()==-2){
                        //activas un metodo EN TABLERO para que quite la torre izquierda y la ponga una a la derecha del rey (efectuando enrroque(){quitarpieza(torreizquierda);tableroFichas[posicion derecha del rey] = new Rook(false);})
                    }
                    if (mov.saltoHorizontal()==2){
                        //activas un metodo EN TABLERO para que quite la torre derecha y la ponga una a la derecha del rey "" "" ""
                    }
                }
                return true;
            }

        }
        else return false;
    }
}
