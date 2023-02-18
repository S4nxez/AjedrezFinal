//import java.util.Scanner;
import Mecanicas.Game;
import Mecanicas.Movement;
import Mecanicas.Tablero;

public class
Main {
    /*chcp 65001 para que se vean las piezas en terminal*/
    public static void main(String[] args) {
        Tablero c = new Tablero();
        Game h = new Game(false);
        Movement mov= null;
        while(!h.getFinPartida()){
            System.out.println('\u2654');
            mov = h.pedirInput(c);
            System.out.println("La pieza es "+c.devuelvePieza(mov.getstartPos().getFila(), mov.getstartPos().getColumna()));
            System.out.println(c.deteccionEnroque(mov));
           if (!c.devuelvePieza(mov.getstartPos().getFila(), mov.getstartPos().getColumna()).movement(mov, c))
               System.out.println("Error, la pieza no se puede mover así");
           //else if(c.hayPiezaEntre(mov))
           //    System.out.println("Error, hay una pieza entre medias y no puedes hacer tu movimiento.");
           else{
               c.moverPieza(mov);
               //c.peonFinal(mov);
               h.cambiarTurno();
             //System.out.println(c.hayPiezaEntre(mov));
           }
        }
        System.out.println(h.decirResultado());
    }
}