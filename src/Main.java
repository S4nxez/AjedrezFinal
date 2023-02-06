//import java.util.Scanner;
import Mecanicas.Movement;
import Mecanicas.Tablero;

public class Main {
    /*chcp 65001 para que se vean las piezas en terminal*/
    public static void main(String[] args) {
        Tablero c = new Tablero();
        Game h = new Game(true);
        Movement mov= null;
        while(!h.getFinPartida()){
            mov = h.pedirInput(c);
           if (!c.devuelvePieza(mov.getstartPos().getFila(), mov.getstartPos().getColumna()).movement(mov, c) && c.hayPiezaEntre(mov))
               System.out.println("Error, la pieza no se puede mover así");
           else{
               c.moverPieza(mov);
               h.cambiarTurno();
               System.out.println(c.isEnrroque());
               System.out.println(c.hayPiezaEntre(mov));
           }
        }
        //System.out.println("Ganan "+h.decirResultado());
    }
}