//import java.util.Scanner;
import Mecanicas.Game;
import Mecanicas.Movement;
import Mecanicas.Tablero;

public class Main {
    /*chcp 65001 para que se vean las piezas en terminal*/
    public static void main(String[] args) {
        Tablero c = new Tablero();
        Game h = new Game(true);
        Movement e= null;

        while(!h.getFinPartida()){
            e = h.pedirInput(c);

            if (!c.devuelvePieza(e.getstartPos().getFila(), e.getstartPos().getColumna()).movement(e, c)){
               if (!c.isNoMasErrores())
                   System.out.println("Error, la pieza no se puede mover así");
            }
            else{
               c.moverPieza(e);
               h.cambiarTurno();
           }
            if(c.jaque(c,h,e)) {
                System.out.println("estas en jaque, cubrete o mueve el rey para continuar.");
            }
        }
        System.out.println(h.decirResultado());
    }
}