import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tablero c = new Tablero();
        Game h = new Game(true);

        String turno = "";
        if (h.getTurn()){
            turno= "blancas";
        }else
            turno="negras";
        c.pintarTablero();
        h.pedirInput();


    }
}