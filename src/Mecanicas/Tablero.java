package Mecanicas;

import java.util.Scanner;

import Figures.*;

/**
 * Tablero
 * 
 * @author NDJ
 */
public class Tablero {
    private ChessFigure tableroFichas[][] = new ChessFigure[8][8];// [FILAS][COLUMNAS]
    public ChessFigure[][] getTableroFichas() {
        return tableroFichas;
    }
    private boolean haciendoenroque=false;

    public boolean isHaciendoenroque() {
        return haciendoenroque;
    }

    public void setHaciendoenroque(boolean haciendoenroque) {
        this.haciendoenroque = haciendoenroque;
    }

    /**
     * Método para asignar fichas a las posiciones del tablero
     */
    public Tablero() {

        //Peon
        for (int i = 0; i < 8; i++)
            tableroFichas[1][i] = new Pawn(true); // negras
        for (int i = 0; i < 8; i++)
            tableroFichas[6][i] = new Pawn(false);// blancas
        // Torres
        tableroFichas[0][0] = new Rook(true);
        tableroFichas[0][7] = new Rook(true); // negras
        tableroFichas[7][0] = new Rook(false);
        tableroFichas[7][7] = new Rook(false); // blancas

        // Caballo
        //tableroFichas[0][1] = new Horse(true);
        tableroFichas[0][6] = new Horse(true); // negras
        //tableroFichas[7][1] = new Horse(false);
        tableroFichas[7][6] = new Horse(false); // blancas

        // Alfiles
        //tableroFichas[0][2] = new Bishop(true);
        tableroFichas[0][5] = new Bishop(true); // negras
        //tableroFichas[7][2] = new Bishop(false);
        tableroFichas[7][5] = new Bishop(false); // blancas

        // Dama
        //tableroFichas[0][3] = new Queen(true);// negras
        //tableroFichas[7][3] = new Queen(false);// blancas

        // Rey
        tableroFichas[0][4] = new King(true);// negras
        tableroFichas[7][4] = new King(false);// blancas

    }

       public void pintarTablero() {
        System.out.println("  [A]  [B]  [C] [D] [E]  [F]  [G]  [H]");
        for (int i = 0; i < tableroFichas.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < tableroFichas.length; j++) {
                if (tableroFichas[i][j] != null)
                    System.out.print(tableroFichas[i][j].getNameFigure() + " ");
                else
                    System.out.print("[⛚] ");
            }
            System.out.println();
        }
       }



    public ChessFigure devuelvePieza(int fila, int columna) {
        return tableroFichas[fila][columna];
    }

    public void moverPieza(Movement mov) {
        tableroFichas[mov.getendPos().getFila()][mov.getendPos()
                .getColumna()] = tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()];
        tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()] = null;
    }

    public boolean hayPieza(int fila, int columna) {
        return tableroFichas[fila][columna] != null;
    }

    public boolean hayPieza(Position pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezaEntre(Movement mov) {
        boolean respuesta = false;
        if (mov.esDiagonal()) {
            if (mov.getstartPos().getFila() < mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() < mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila() +1,
                        j = mov.getstartPos().getColumna() +1; i < mov.getendPos().getFila() - 1; i++, j++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() > mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() < mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila()-1,
                        j = mov.getstartPos().getColumna()+1; i > mov.getendPos().getFila() + 1; i--, j++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() > mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() > mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila()-1,
                        j = mov.getstartPos().getColumna()-1; i > mov.getendPos().getFila() + 1; i--, j--) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() < mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() > mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila()+1,
                        j = mov.getstartPos().getColumna()-1; i < mov.getendPos().getFila() - 1; i++, j--) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            }
        } if(mov.esHorizontal() && !mov.esVertical() && mov.saltoHorizontal()!=1){
            int i = mov.getstartPos().getFila();
            int col1= mov.getstartPos().getColumna();
            int col2= mov.getendPos().getColumna();
            if (col1<col2){
                for (int j = col1; j < col2-1; j++) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                        break;
                    }
                }
            }
            else{
                for (int j = col1; j > col2+1; j--) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                        break;
                    }
                }
            }
        }
        else if (!mov.esHorizontal() && mov.esVertical() && mov.saltoVertical()!=1){
            int j = mov.getstartPos().getColumna();
            int fila1= mov.getstartPos().getFila();
            int fila2= mov.getendPos().getFila();

            if (fila1 > fila2){//peones blancos
                if(mov.getstartPos().getFila() == 6){
                    for (int i=fila1-1; i>fila2; i--){
                        if (hayPieza(i,j)){
                            respuesta=true;
                        }
                    }
                } else {
                    if (fila2-fila1==1){
                        if (hayPieza(fila2,j)){
                            respuesta=true;
                        }
                    }
                }
            }
            else if (fila1 < fila2){//peones negros
                if (fila1-fila2!=1) {
                    for (int i = fila1 + 1; i < fila2; i++) {
                        if (hayPieza(i, j)) {
                            respuesta = true;
                        }
                    }
                } else {
                    if (fila1-fila2==1){
                        if (hayPieza(fila2,j)){
                            respuesta=true;
                        }
                    }
                }
            }
        }
        return respuesta;
    }
    public void peonFinal(Movement mov){
        //si hay un peon en la fila1 o fila8 se le pregunta al usuario la ficha por la que se quiere cambiar.
        Scanner sc = new Scanner(System.in);
        if (devuelvePieza(mov.getendPos().getFila(), mov.getendPos().getColumna()).getNameFigure()=="[♙]" && mov.getendPos().getFila()==0){
            quitaPieza(0,mov.getendPos().getColumna());
            int fichanueva=0;
            while (fichanueva==0){
                System.out.println("Has llegado a la última fila, elija por qué ficha quiere que se cambie el peon: \n1.- Reina\n2.-ALfil\n3.-Caballo\n4.-Torre\n");
                fichanueva=sc.nextInt();
                switch(fichanueva){
                    case 1://reina
                    tableroFichas[0][mov.getendPos().getColumna()] = new Queen(false);
                    break;
                    case 2://alfil
                    tableroFichas[0][mov.getendPos().getColumna()] = new Bishop(false);
                    break;
                    case 3://caballo
                    tableroFichas[0][mov.getendPos().getColumna()] = new Horse(false);
                    break;
                    case 4://torre
                    tableroFichas[0][mov.getendPos().getColumna()] = new Rook(false);
                    break;
                    default:
                    System.out.println("Elija un número dentro del rango establecido");
                    fichanueva=0;
                }
            }
        }
        else if(devuelvePieza(mov.getendPos().getFila(), mov.getendPos().getColumna()).getNameFigure()=="[♟]" && mov.getendPos().getFila()==7){
            quitaPieza(7,mov.getendPos().getColumna());
            int fichanueva=0;
            while (fichanueva==0){
                System.out.println("Has llegado a la última fila, elija por qué ficha quiere que se cambie el peon: \n1.- Reina\n2.-ALfil\n3.-Caballo\n4.-Torre\n");
                fichanueva=sc.nextInt();
                switch(fichanueva){
                    case 1://reina
                    tableroFichas[7][mov.getendPos().getColumna()] = new Queen(true);
                    break;
                    case 2://alfil
                    tableroFichas[7][mov.getendPos().getColumna()] = new Bishop(true);
                    break;
                    case 3://caballo
                    tableroFichas[7][mov.getendPos().getColumna()] = new Horse(true);
                    break;
                    case 4://torre
                    tableroFichas[7][mov.getendPos().getColumna()] = new Rook(true);
                    break;
                    default:
                    System.out.println("Elija un número dentro del rango establecido");
                    fichanueva=0;
                }
            }
        }
        
    }

    public void quitaPieza(int fila, int columna) {
        tableroFichas[fila][columna] = null;
    }
    public String deteccionEnroque(Movement mov) {
        int ul=0, ur=0, dl=0, dr=0, mt=0, mb=0;//up down left right
        if (tableroFichas[0][0] == null)ul++;
        if(tableroFichas[7][0] == null)ur++;
        if(tableroFichas[0][7] == null)dl++;
        if(tableroFichas[7][7] == null)dr++;
        if(tableroFichas[0][4] == null)mt++;
        if(tableroFichas[7][4] == null)mb++;
        return "" + ul + ur + dl + dr + mt + mb;

    }

    public void efectuarenroque(boolean color, String tipo, Movement mov){
        if (color==true){
            if (tipo=="largo"){
                quitaPieza(0,0);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()+1]=new Rook(true);
            }
            if (tipo=="corto"){
                quitaPieza(0,7);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()-1]=new Rook(true);
            }
        }
        if (color==false){
            if (tipo=="largo"){
                quitaPieza(7,0);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()+1]=new Rook(false);
            }
            if (tipo=="corto"){
                quitaPieza(7,7);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()-1]=new Rook(false);
            }
        }
    }



    public boolean jaque(Tablero tb, Movement mov, ChessFigure figura, Game turn){

        boolean amenaza=false;
        boolean turno;
        turno = turn.getTurn();
        while(!amenaza){ //este bucle es infinito si no le hacen jaque
            //busca vertical arriba
            //no se si las piezas que he puesto coinciden bien con el turno y hay que usar el equals creo
            for (int i=mov.getstartPos().getColumna()-1;i!=0;i--){
                if(tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♜]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♖]"&& !turno){
                    amenaza=true;
                }else if (tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♛]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♕]"&& !turno){
                    amenaza=true;
                }
            }
            //busca vertical abajo
            for (int i = 7-mov.getstartPos().getColumna(); i !=0; i--) {
                if(tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♜]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♖]"&& !turno){
                    amenaza=true;
                }else if (tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♛]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♕]"&& !turno){
                    amenaza=true;
                }
            }
            //busca hotizontal derecha
            for (int i=mov.getstartPos().getFila()-1;i!=0;i--){
                if(tableroFichas[mov.getstartPos().getFila()][i].getNameFigure()=="[♜]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♖]"&& !turno){
                    amenaza=true;
                }else if (tableroFichas[mov.getstartPos().getFila()][i].getNameFigure()=="[♛]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♕]"&& !turno){
                    amenaza=true;
                }
            }
            //busca hotizontal derecha
            for (int i = 7-mov.getstartPos().getFila(); i !=0; i--) {
                if(tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♜]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♖]"&& !turno){
                    amenaza=true;
                }else if (tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♛]"&& turno|tableroFichas[i][mov.getstartPos().getFila()].getNameFigure()=="[♕]"&& !turno){
                    amenaza=true;
                }
            }
        }
        if (amenaza) return true;
        else return false;
    }
}
