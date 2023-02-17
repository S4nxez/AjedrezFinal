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

    /**
     * Método para regular el movimiento del rey
     * @param mov
     * @param tb
     * @return
     */
    @Override
    public boolean movement(Movement mov, Tablero tb) {
        boolean respuesta =false;
        if (mov.esDiagonal()&&(Math.abs(mov.saltoVertical()) + Math.abs(mov.saltoHorizontal()) == 2 ))
            respuesta= true;
        else if (Math.abs(mov.saltoVertical())==1 && mov.esVertical())
            respuesta= true;
        else if (mov.esHorizontal()){
            if (Math.abs(mov.saltoHorizontal())==1)
                respuesta= true;
            if(mov.saltoHorizontal()==2 || mov.saltoHorizontal()==-2){
                if (getColor()==true && tb.deteccionEnroque(mov).charAt(5)=='0' /*si el rey negro no se ha movido de su posicion inicial*/){
                    respuesta=true;
                    if (mov.saltoHorizontal()==-2){
                        //activas un metodo EN TABLERO para que quite la torre izquierda y la ponga una a la derecha del rey (efectuando enrroque(){quitarpieza(torreizquierda);tableroFichas[posicion derecha del rey] = new Rook(true);})
                        for (int j = 3, i=0; j > 1; j--) {
                            if (tb.hayPieza(i,j)){
                                respuesta=false;
                            }
                        }
                        if(respuesta){
                            tb.efectuarenroque(true, "largo",mov);
                        }
                        else System.out.println("No puedes hacer enrroque");
                    }
                    if (mov.saltoHorizontal()==2){
                        //activas un metodo EN TABLERO para que quite la torre derecha y la ponga una a la derecha del rey "" "" ""
                        for (int j = 3, i=7; j > 0; j++) {
                            if (tb.hayPieza(i,j)){
                                respuesta=false;
                            }
                        }
                        if(respuesta){
                            tb.efectuarenroque(true, "corto",mov);
                        }
                    }
                }
                if (getColor()==false && tb.deteccionEnroque(mov).charAt(5)=='0' /*si el rey blanco no se ha movido de su posicion inicial*/){
                    respuesta=true;
                    if (mov.saltoHorizontal()==-2){
                        //activas un metodo EN TABLERO para que quite la torre izquierda y la ponga una a la derecha del rey (efectuando enrroque(){quitarpieza(torreizquierda);tableroFichas[posicion derecha del rey] = new Rook(true);})
                        for (int j = 3, i=7; j > 1; j--) {
                            if (tb.hayPieza(i,j)){
                                respuesta=false;
                            }
                        }
                        if(respuesta){
                            tb.efectuarenroque(false, "largo",mov);
                        }
                        else System.out.println("No puedes hacer enrroque");
                    }
                    if (mov.saltoHorizontal()==2){
                        //activas un metodo EN TABLERO para que quite la torre derecha y la ponga una a la derecha del rey "" "" ""
                        for (int j = 3, i=0; j > 0; j++) {
                            if (tb.hayPieza(i,j)){
                                respuesta=false;
                            }
                        }
                        if(respuesta){
                            tb.efectuarenroque(false, "corto",mov);
                        }
                    }
                }
            }

        }
        return respuesta;
    }
}
