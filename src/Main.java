//import java.util.Scanner;
import Mecanicas.Game;
import Mecanicas.Movement;
import Mecanicas.Tablero;

public class Main {
    /*chcp 65001 para que se vean las piezas en terminal*/

    public static void main(String[] args) {
        Tablero c = new Tablero();
        Game h = new Game(false);
        Movement mov= null;
        while(!h.getFinPartida()){
            mov = h.pedirInput(c);
            System.out.println("La pieza es "+c.devuelvePieza(mov.getstartPos().getFila(), mov.getstartPos().getColumna()));
            System.out.println(c.deteccionEnroque(mov));
           if (!c.devuelvePieza(mov.getstartPos().getFila(), mov.getstartPos().getColumna()).movement(mov, c)){
               if (!c.isNoMasErrores())
                   System.out.println("Error, la pieza no se puede mover así");
           }
        else{
               c.moverPieza(mov);
               h.cambiarTurno();
           }
        }
        System.out.println(h.decirResultado());
    }
}