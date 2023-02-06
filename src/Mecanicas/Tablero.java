package Mecanicas;

import Figures.*;

public class Tablero {
    private ChessFigure tableroFichas[][] = new ChessFigure[8][8];
    // [FILAS][COLUMNAS]
    public ChessFigure[][] getTableroFichas() {
        return tableroFichas;
    }

    private boolean enrroque=true;
    public boolean isEnrroque() {
        return enrroque;
    }
    public void setEnrroque(boolean enrroque) {
        this.enrroque = enrroque;
    }

    public Tablero() {

        //Peon
        for (int i = 0; i < 8; i++)
            tableroFichas[1][i] = new Pawn(true); // negras
        for (int i = 0; i < 8; i++)
            tableroFichas[6][i] = new Pawn(false);// blancas

        //Torres
        tableroFichas[0][0] = new Rook(true);
        tableroFichas[0][7] = new Rook(true); //negras
        tableroFichas[7][0] = new Rook(false);
        tableroFichas[7][7] = new Rook(false); //blancas

        //Caballo
        tableroFichas[0][1] = new Horse(true);
        tableroFichas[0][6] = new Horse(true); //negras
        tableroFichas[7][1] = new Horse(false);
        tableroFichas[7][6] = new Horse(false); //blancas

        //Alphiles
        tableroFichas[0][2] = new Bishop(true);
        tableroFichas[0][5] = new Bishop(true); //negras
        tableroFichas[7][2] = new Bishop(false);
        tableroFichas[7][5] = new Bishop(false); //blancas

        //Dama
        tableroFichas[0][3] = new Queen(true);//negras
        tableroFichas[7][3] = new Queen(false);//blancas

        //Rey
        tableroFichas[0][4] = new King(true);//negras
        tableroFichas[7][4] = new King(false);//blancas

    }


    public void pintarTablero() {
        for (int i = 0; i < tableroFichas.length; i++) {
            for (int j = 0; j < tableroFichas.length; j++) {
                if (tableroFichas[i][j] != null)
                    System.out.print(tableroFichas[i][j].getNameFigure(i,j));
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
    }
    public ChessFigure devuelvePieza(int fila, int columna) {
        return tableroFichas[fila][columna];
    }

    public void moverPieza(Movement mov) {
        if (!hayPiezaEntre(mov)){
            tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()] = tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()];
            tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()] = null;
        }
    }
    public void enrroque(){
        if (tableroFichas[0][0]==null||
                tableroFichas[7][0]==null||
                tableroFichas[0][7]==null||
                tableroFichas[7][7]==null){enrroque=false;}
    }
    public boolean hayPieza(int fila, int columna) {
        return tableroFichas[fila][columna]!= null;
    }

    public boolean hayPieza(Position pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezaEntre(Movement mov){
        boolean respuesta = false;
        if (mov.esDiagonal()){
            if (mov.getstartPos().getFila() < mov.getendPos().getFila() && mov.getstartPos().getColumna() < mov.getendPos().getColumna()){
                for (int i = mov.getstartPos().getFila(), j=mov.getstartPos().getColumna(); i == (mov.getendPos().getFila()); i++, j++) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                    }
                }
            }
            else if (mov.getstartPos().getFila() > mov.getendPos().getFila() && mov.getstartPos().getColumna() < mov.getendPos().getColumna()){
                for (int i = mov.getstartPos().getFila(), j=mov.getstartPos().getColumna(); i == (mov.getendPos().getFila()); i--, j++) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                    }
                }
            }
            else if (mov.getstartPos().getFila() > mov.getendPos().getFila() && mov.getstartPos().getColumna() > mov.getendPos().getColumna()){
                for (int i = mov.getstartPos().getFila(), j=mov.getstartPos().getColumna(); i == (mov.getendPos().getFila()); i--, j--) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                    }
                }
            }
            else if (mov.getstartPos().getFila() < mov.getendPos().getFila() && mov.getstartPos().getColumna() > mov.getendPos().getColumna()){
                for (int i = mov.getstartPos().getFila(), j=mov.getstartPos().getColumna(); i == (mov.getendPos().getFila()); i--, j--) {
                    if (hayPieza(i,j)){
                        respuesta=true;
                    }
                }
            }
        }
        else if(mov.esHorizontal() && !mov.esVertical()){
            int i = mov.getstartPos().getFila();
            int col1= mov.getstartPos().getColumna();
            int col2= mov.getendPos().getColumna();
            if (col1>col2) {
                for (int j = col1; j < col2; j++) {
                    if (hayPieza(i,j)){
                        return false;
                    }
                    else return true;
                }
            }
            else {
                for (int j = col1; j < col1; j++) {
                    if (hayPieza(i,j)){
                        return false;
                    }
                    else return true;
                }
            }
        }
        else if (mov.esVertical() && !mov.esHorizontal()){
            int j =mov.getstartPos().getColumna();
            int fila1= mov.getstartPos().getFila();
            int fila2= mov.getendPos().getFila();
            if (fila1>fila2){
                for (int i = fila1; i > fila1 ; i++) {
                    if (hayPieza(i,j))
                        respuesta=true;
                }
            }
            else{
                for (int i = fila1; i < fila2; i++) {
                    if (hayPieza(i,j))
                        respuesta=true;
                }
            }
        }
        return respuesta;
    }
    public boolean quitaPieza(int fila, int columna){return tableroFichas[fila][columna]==null;}
    public boolean quitaPieza(Position pos){
        return quitaPieza(null);}



}
