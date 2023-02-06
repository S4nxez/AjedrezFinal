import Mecanicas.Position;
import Mecanicas.Tablero;
import Mecanicas.Movement;
import java.util.Scanner;

public class Game {
    
    Scanner scanner = new Scanner(System.in);
    private boolean Turn;
    private String Jugada;
    private boolean finPartida;

    public Game(boolean Turn){
        this.finPartida = false;
        this.Turn = Turn;
    }

    public boolean getFinPartida() {
        return this.finPartida;
    }

    public void cambiarTurno(){
        Turn=!Turn;
    }

    public boolean getTurn(){
        return Turn;
    }

    public void setTurno(boolean turno) {
        this.Turn = turno;
    }

    /**
     * @return pedirInput
     * Método que pide al usuario la jugada que quiere realizar, con varias excepciones de reglas básicas como no dejar comerte fichas
     * de tu propio color entre otras. El Método te devuelve la jugada "validada" para que las clases movimiento o posición puedan recibirlas.
     */
    public Movement pedirInput(Tablero tb){
        boolean jugadaValida=false, finPartida=false;
        Movement mov = null;
        String turno;



        tb.pintarTablero();
        while (!jugadaValida) {
            turno = getTurn() ? "blancas" : "negras";
            System.out.println("Judador de " + turno + ", ingrese la jugada (ej. e2e4): ");

            Jugada = scanner.nextLine();
            Jugada = Jugada.toUpperCase();
            if (Jugada.length() != 4) {
                System.out.println("E: Longitud de jugada no valida");
            }else {
                int i, j, k, l;
                j = Jugada.charAt(0) - 65; //columnaInicial
                i = Jugada.charAt(1) - 49; // filaInicial
                l = Jugada.charAt(2) - 65; //columnaFinal
                k = Jugada.charAt(3) - 49;//filaFinal

                System.out.println(j + "" + i + "" + l + "" + k);

                jugadaValida = false;

                if (i <= 0 && i >= 7 || k >= 0 && k >= 7) {
                    System.out.println("E: Escribe las coordenadas correctamente. Letras de la A a la H");
                } else if (j <= 0 && j >= 7 || l <= 0 && l >= 7) {
                    System.out.println("E: Escribe las coordenadas correctamente. Números comprendidos del 1 al 8");
                }
                //else if(tb.getTableroFichas()[i][j] == null){
                else if (!tb.hayPieza(i, j)) {
                    System.out.println("Ahí no hay pieza.");
                } else if (tb.hayPieza(k, l) && tb.getTableroFichas()[k][l].getColor() == tb.getTableroFichas()[i][j].getColor()) {
                    System.out.println("Que haces comiéndote tu propia ficha? No puedes");
                } else if (tb.devuelvePieza(i, j).getColor() == Turn/*EL TURNO Y EL COLOR DE LAS FIGURAS ESTÁ AL REVÉS*/) {
                    System.out.println("Debes mover una ficha de tu color");
                } else {
                    jugadaValida = true;
                    mov = new Movement(new Position(i, j), new Position(k, l));
                }
            }
        }
        return mov;
    }
    /*public String decirResultado(){//metodo que nos da el ganador en un string para hacer el sout en el main
        if(getTurn() == true && mate== true)
            resultado="ganan true";
        else if(getTurn() == false && mate == true)
            resutlado="ganan false";
        return resultado;
    }*/
}
