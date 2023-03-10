package Mecanicas;
import java.util.Scanner;

/**
 * Clase Game
 */

public class Game {
    
    Scanner scanner = new Scanner(System.in);
    private boolean Turn;private boolean jaquemate;private boolean finPartida;
    private String Jugada; private String resultado;

    public Game(boolean Turn){
        this.finPartida = false;
        this.Turn = Turn;
    }

    /**
     * Método getter de la variable FinPartida
     * @return
     */
    public boolean getFinPartida() {
        return this.finPartida;
    }

    /**
     * Método getter de la variable Turn
     * @return
     */
    public boolean getTurn(){
        return Turn;
    }

    /**
     * Método Para cambiar el booleando Turn
     * @param turno
     */
    public void setTurno(boolean turno) {
        this.Turn = turno;
    }

    /**
     * Método que cambia el turno
     */
    public void cambiarTurno(){
        Turn=!Turn;
    }

    /**
     * Método getter de la variable Jaquemate
     * @return
     */
    public boolean isJaquemate() {
        return jaquemate;
    }

    /**
     * Método que cambia el booleano Jaquemate
     * @param jaquemate
     */
    public void setJaquemate(boolean jaquemate) {
        this.jaquemate = jaquemate;
    }

    /**
     * Método que pide al usuario la jugada que quiere realizar, con varias excepciones de reglas básicas como no dejar comerte fichas
     * de tu propio color entre otras. El Método te devuelve la jugada "validada" para que las clases movimiento o posición puedan recibirlas.
     * @param tb
     * @return pedirInput
     */
    public Movement pedirInput(Tablero tb){
        boolean jugadaValida=false;
        Movement mov = null;
        String turno;

        while (!jugadaValida) {
            tb.pintarTablero();
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

                if (j < 0 || j > 7 || l < 0 || l > 7) {
                    System.out.println("E: Escribe las coordenadas correctamente. Letras de la A a la H");
                } else if (i < 0 || i > 7 || k < 0 || k > 7) {
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
    /**
     * Método que nos da el ganador en un string para hacer el sout en el main.
     * @return resutado del ganador de la partida
     */
    public String decirResultado(){
        if(getTurn() == true && jaquemate== true)
            resultado="ganan true";
        else if(getTurn() == false && jaquemate == true)
            resultado="ganan false";
        return resultado;
    }
}
