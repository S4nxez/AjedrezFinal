import Figures.ChessFigure;
import java.util.Scanner;

public class Game {
    private boolean Turn;
    private String Jugada;
    Tablero Tb = new Tablero();
    private ChessFigure[][] tableroCopia = Tb.getTableroFichas();
    public Game(boolean Turn){
        this.Turn=Turn;
    }
    public boolean getTurn(){
        return Turn;
    }
    public void setTurn(){
        this.Turn=Turn;
    }
    public String pedirInput(){
        Scanner scanner = new Scanner(System.in);
        boolean jugadaValida=false;
        while (!jugadaValida){
            System.out.println("Ingrese la jugada (ej. e2-e4): ");
            Jugada = scanner.nextLine();
            Jugada = Jugada.toUpperCase();
            int i,j,k,l;
            i = (Jugada.charAt(0)-65);
            j = (Jugada.charAt(1)-49);
            k = (Jugada.charAt(2)-65);
            l = (Jugada.charAt(3)-49);

            jugadaValida = false;
            if (Jugada.length()!=4){
                System.out.println("E: Longitud de jugada no valida");

            }
            else if (Jugada.charAt(1) >='A' && Jugada.charAt(1) <='H' || Jugada.charAt(3) >='A' && Jugada.charAt(3) <='H'){
                System.out.println("E: Escribe las coordenadas correctamente. Letras de la A a la H");
            }
            else if (Jugada.charAt(2) >= 49 && Jugada.charAt(2) <= 56 || Jugada.charAt(4) >=49 && Jugada.charAt(4) <= 56 ){
                System.out.println("E: Escribe las coordenadas correctamente. Números comprendidos del 1 al 8");
            }
            else if(tableroCopia[i][j] == null){
                System.out.println("Ahí no hay pieza.");}
            else if(tableroCopia[i][j].getColor()!=Turn){
                System.out.println("Debes mover una ficha de tu color");
            }
            else if (tableroCopia[i][j].getColor() == tableroCopia[k][l].getColor()){
                System.out.println("Que haces comiéndote tu propia ficha? No puedes");}
            else
                jugadaValida=true;
        }
        return Jugada;
    }
}
