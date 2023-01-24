import Figures.*;

public class Tablero {
    private ChessFigure tableroFichas[][] = new ChessFigure[8][8];
    // [FILAS][COLUMNAS]

    public Tablero() {

        for (int i = 0; i < 8; i++)
            tableroFichas[1][i] = new Pawn(true); // negras
        for (int i = 0; i < 8; i++)
            tableroFichas[6][i] = new Pawn(false);// blancas

        //torres
        tableroFichas[0][0] = new Rook(true); tableroFichas[0][7] = new Rook(true); //negras
        tableroFichas[7][0] = new Rook(false); tableroFichas[7][7] = new Rook(false); //blancas
        
        //Caballo
        tableroFichas[0][1] = new Horse(true); tableroFichas[0][6] = new Horse(true); //negras
        tableroFichas[7][1] = new Horse(false); tableroFichas[7][6] = new Horse(false); //blancas

        //Alfiles
        tableroFichas[0][2] = new Bishop(true); tableroFichas[0][5] = new Bishop(true); //negras
        tableroFichas[7][2] = new Bishop(false); tableroFichas[7][5] = new Bishop(false); //blancas

        //Dama
        tableroFichas[0][3] = new Queen(true);//negras
        tableroFichas[7][3] = new Queen(false);//blancas

        //Rey
        tableroFichas[0][4] = new King(true);
        tableroFichas[7][4] = new King(false);





    }

    public void pintarTablero() {
        for (int i = 0; i < tableroFichas.length; i++) {
            for (int j = 0; j < tableroFichas.length; j++) {
                if (tableroFichas[i][j] != null)
                    System.out.print(tableroFichas[i][j].printChessFigure());
                else
                    System.out.print("--");

            }
            System.out.println();
        }
    }
}
