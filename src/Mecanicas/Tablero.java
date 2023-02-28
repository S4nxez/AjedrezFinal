package Mecanicas;
import java.util.Scanner;
import Figures.*;

/**
 * Clase Tablero
 */
public class Tablero {
    private ChessFigure tableroFichas[][] = new ChessFigure[8][8];// [FILAS][COLUMNAS]

    
    /** 
     * @return ChessFigure[][]
     */
    public ChessFigure[][] getTableroFichas() {
        return tableroFichas;
    }

    private boolean haciendoenroque = false;

    /**
     * El getter de Hacciendoenrroque
     * @return
     */

    public boolean isHaciendoenroque() {
        return haciendoenroque;
    }

    /**
     * El setter de haciendoenrroque
     * @param haciendoenroque
     */
    public void setHaciendoenroque(boolean haciendoenroque) {
        this.haciendoenroque = haciendoenroque;
    }

    private boolean nomaserrores;

    /**
     * El getter de nomaserrores
     * @return
     */

    public boolean isNoMasErrores() {
        return nomaserrores;
    }

    /**
     * el setter de nomaserrores
     * @param nomaserrores
     */

    public void setNomaserrores(boolean nomaserrores) {
        this.nomaserrores = nomaserrores;
    }

    /**
     * Método para asignar fichas a las posiciones del tablero
     */
    public Tablero() {
        /*
        //Peon
        for (int i = 0; i < 8; i++)
            tableroFichas[1][i] = new Pawn(true); // negras
        for (int i = 0; i < 8; i++)
            tableroFichas[6][i] = new Pawn(false);// blancas
        */
        // Torres
        tableroFichas[0][0] = new Rook(true);
        tableroFichas[0][7] = new Rook(true); // negras
        tableroFichas[7][0] = new Rook(false);
        tableroFichas[7][7] = new Rook(false); // blancas

        // Caballo
        tableroFichas[0][1] = new Horse(true);
        tableroFichas[0][6] = new Horse(true); // negras
        tableroFichas[7][1] = new Horse(false);
        tableroFichas[7][6] = new Horse(false); // blancas

        // Alfiles
        tableroFichas[0][2] = new Bishop(true);
        tableroFichas[0][5] = new Bishop(true); // negras
        tableroFichas[7][2] = new Bishop(false);
        tableroFichas[7][5] = new Bishop(false); // blancas

        // Dama
        tableroFichas[0][3] = new Queen(true);// negras
        tableroFichas[7][3] = new Queen(false);// blancas

        // Rey
        tableroFichas[0][4] = new King(true);// negras
        tableroFichas[7][4] = new King(false);// blancas

    }

    /**
     * Metodo que imprime el tablero en consola para el usuario
     */
    public void pintarTablero() {
        System.out.println("  [A]  [B]  [C] [D] [E]  [F]  [G]  [H]");
        for (int i = 0; i < tableroFichas.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tableroFichas.length; j++) {
                if (tableroFichas[i][j] != null)
                    System.out.print(tableroFichas[i][j].getNameFigure() + " ");
                else
                    System.out.print("[⛚] ");
            }
            System.out.println();
        }
    }

    /**
     * metodo que te devuelve la pieza de una posicion específica del tablero
     * @param fila
     * @param columna
     * @return
     */
    public ChessFigure devuelvePieza(int fila, int columna) {
        return tableroFichas[fila][columna];
    }

    /**
     * método que mueve la pieza basándose en el movimiento recibido
     * @param mov
     */
    public void moverPieza(Movement mov) {
        tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna()] = tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()];
        tableroFichas[mov.getstartPos().getFila()][mov.getstartPos().getColumna()] = null;
    }

    /**
     * método que indica si hay una pieza en la ubicación del tablero especificada
     * @param fila
     * @param columna
     * @return
     */
    public boolean hayPieza(int fila, int columna) {
        return tableroFichas[fila][columna] != null;
    }

    /**
     * método que indica si hay una pieza en la ubicación del tablero especificada
     * @param pos
     * @return
     */
    public boolean hayPieza(Position pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    /**
     * método que indica si hay una pieza entre medias del movimiento que se va a realizar.
     * @param mov
     * @return
     */
    public boolean hayPiezaEntre(Movement mov) {
        boolean respuesta = false;
        if (mov.esDiagonal()) {
            if (mov.getstartPos().getFila() < mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() < mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila() + 1,
                     j = mov.getstartPos().getColumna() + 1; i < mov.getendPos().getFila() - 1; i++, j++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() > mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() < mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila() - 1,
                     j = mov.getstartPos().getColumna() + 1; i > mov.getendPos().getFila() + 1; i--, j++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() > mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() > mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila() - 1,
                     j = mov.getstartPos().getColumna() - 1; i > mov.getendPos().getFila() + 1; i--, j--) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            } else if (mov.getstartPos().getFila() < mov.getendPos().getFila()
                    && mov.getstartPos().getColumna() > mov.getendPos().getColumna()) {
                for (int i = mov.getstartPos().getFila() + 1,
                     j = mov.getstartPos().getColumna() - 1; i < mov.getendPos().getFila() - 1; i++, j--) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            }
        }
        if (mov.esHorizontal() && !mov.esVertical() && mov.saltoHorizontal() != 1) {
            int i = mov.getstartPos().getFila();
            int col1 = mov.getstartPos().getColumna();
            int col2 = mov.getendPos().getColumna();
            if (col1 < col2) {
                for (int j = col1; j < col2 - 1; j++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                        break;
                    }
                }
            } else {
                for (int j = col1; j > col2 + 1; j--) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                        break;
                    }
                }
            }
        }
        if (mov.esVertical() && !mov.esHorizontal() && mov.saltoVertical() != 1) {
            int j = mov.getstartPos().getColumna();//columna
            int fila1 = mov.getstartPos().getFila();//fila inicial
            int fila2 = mov.getendPos().getFila();//fila final

            if (fila1 > fila2) {//si va hacia arriba
                if (fila2 - fila1 == 1) {
                    if (hayPieza(fila2, j)) {
                        respuesta = true;
                    }
                } else {
                    for (int i = fila1 - 1; i > fila2; i--) {
                        if (hayPieza(i, j)) {
                            respuesta = true;
                        }
                    }
                }
            } else if (fila1 < fila2) {//si va hacia abajo
                if (fila1 - fila2 != 1) {
                    for (int i = fila1 + 1; i < fila2; i++) {
                        if (hayPieza(i, j)) {
                            respuesta = true;
                        }
                    }
                } else {
                    if (fila1 - fila2 == 1) {
                        if (hayPieza(fila2, j)) {
                            respuesta = true;
                        }
                    }
                }
                for (int i = fila1 + 1; i > fila2; i++) {
                    if (hayPieza(i, j)) {
                        respuesta = true;
                    }
                }
            }
        }
        return respuesta;
    }

    /**
     * método que gestiona el renombramiento del peon pidiéndole al usuario la ficha por la que quiere que se cambie
     * @param mov
     */
    public void peonFinal(Movement mov) {//promocion
        Scanner sc = new Scanner(System.in);
        if (devuelvePieza(mov.getendPos().getFila(), mov.getendPos().getColumna()).getNameFigure() == "[♙]" && mov.getendPos().getFila() == 0) {
            quitaPieza(0, mov.getendPos().getColumna());
            int fichanueva = 0;
            while (fichanueva == 0) {
                System.out.println("Has llegado a la última fila, elija por qué ficha quiere que se cambie el peon: \n1.- Reina\n2.-ALfil\n3.-Caballo\n4.-Torre\n");
                fichanueva = sc.nextInt();
                switch (fichanueva) {
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
                        fichanueva = 0;
                }
            }
        } else if (devuelvePieza(mov.getendPos().getFila(), mov.getendPos().getColumna()).getNameFigure() == "[♟]" && mov.getendPos().getFila() == 7) {
            quitaPieza(7, mov.getendPos().getColumna());
            int fichanueva = 0;
            while (fichanueva == 0) {
                System.out.println("Has llegado a la última fila, elija por qué ficha quiere que se cambie el peon: \n1.- Reina\n2.-ALfil\n3.-Caballo\n4.-Torre\n");
                fichanueva = sc.nextInt();
                switch (fichanueva) {
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
                        fichanueva = 0;
                }
            }
        }

    }

    /**
     * método que quita una pieza en la posiicon del tablero que se especifique
     * @param fila
     * @param columna
     */
    public void quitaPieza(int fila, int columna) {
        tableroFichas[fila][columna] = null;
    }

    /**
     * método el cual detecta si una ficha de ha movido para saber si se puede efectuar el enrroque
     * @param mov
     * @return
     */
    public String deteccionEnroque(Movement mov) {
        int ul = 0, ur = 0, dl = 0, dr = 0, mt = 0, mb = 0;//up down left right
        if (tableroFichas[0][0] == null) ul++;
        if (tableroFichas[7][0] == null) ur++;
        if (tableroFichas[0][7] == null) dl++;
        if (tableroFichas[7][7] == null) dr++;
        if (tableroFichas[0][4] == null) mt++;
        if (tableroFichas[7][4] == null) mb++;
        return "" + ul + ur + dl + dr + mt + mb;

    }

    /**
     * método que efectua el enrroque del tipo y color especificados
     * @param color
     * @param tipo
     * @param mov
     */
    public void efectuarenroque(boolean color, String tipo, Movement mov) {
        if (color == true) {
            if (tipo == "largo") {
                quitaPieza(0, 0);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna() + 1] = new Rook(true);
            }
            if (tipo == "corto") {
                quitaPieza(0, 7);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna() - 1] = new Rook(true);
            }
        }
        if (color == false) {
            if (tipo == "largo") {
                quitaPieza(7, 0);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna() + 1] = new Rook(false);
            }
            if (tipo == "corto") {
                quitaPieza(7, 7);
                tableroFichas[mov.getendPos().getFila()][mov.getendPos().getColumna() - 1] = new Rook(false);
            }
        }
    }

    /**
     * método que detecta si un rey se ve amenazado
     * @param tb
     * @param g
     * @param mov
     * @return
     */
    public boolean jaque(Tablero tb, Game g, Movement mov) {
        boolean amenaza = false;
        boolean turno = g.getTurn(); // true es negras false es blancas

        int filarey = 0, columnarey = 0;
        if (!turno) { // identifica si el rey negro está en jaque
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) { // busca al rey en el tablero
                    if (tableroFichas[i][j] != null && tableroFichas[i][j].getNameFigure() == "[♚]") {
                        filarey = i;
                        columnarey = j;
                        break;
                    }
                }
            }

            // VERTICALES (solo torre y reina)
            if (filarey != 0) {
                for (int i = filarey - 1, j = columnarey; i >= 0; i--) { // busca vertical arriba, se restan las filas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♖]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7) {
                for (int i = filarey + 1, j = columnarey; i <= 7; i++) { // busca vertical abajo, se suman las filas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♖]"
                            || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }

            // HORIZONTALES (solo torre y reina)
            if (columnarey != 0) {
                for (int i = filarey, j = columnarey - 1; j >= 0; j--) { // busca horizontal izquierda, se restan las columnas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♖]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (columnarey != 7) {
                for (int i = filarey, j = columnarey + 1; j <= 7; j++) { // busca horizontal derecha, se suman las columnas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♖]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            // DIAGONALES (solo alfil y reina)
            if (filarey != 0 && columnarey != 0) {
                for (int i = filarey - 1, j = columnarey - 1; i >= 0 && j >= 0; i--, j--) { // busca diagonal izquierda arriba
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♗]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 0 && columnarey != 7) {
                for (int i = filarey - 1, j = columnarey + 1; i >= 0 && j <= 7; i--, j++) { // busca diagonal derecha arriba
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♗]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7 && columnarey != 0) {
                for (int i = filarey + 1, j = columnarey - 1; i <= 7 && j >= 0; i++, j--) { // busca diagonal izquierda abajo
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♗]" || tableroFichas[i][j].getNameFigure() == "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7 && columnarey != 7) {
                for (int i = filarey + 1, j = columnarey + 1; i <= 7 && j <= 7; i++, j++) { // busca diagonal derecha abajo
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♗]" || tableroFichas[i][j].getNameFigure() ==
                            "[♕]")) {
                        amenaza = true;
                        break;
                    }
                }
            }

            // CABALLOS
            int[] filaCaballos = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] columnaCaballos = {1, 2, 2, 1, -1, -2, -2, -1};
            for (int i = 0; i < 8; i++) {
                int fila = filarey + filaCaballos[i];
                int columna = columnarey + columnaCaballos[i];
                if (fila >= 0 && fila <= 7 && columna >= 0 && columna <= 7) { // verifica que la posición sea válida en el tablero
                    if (tableroFichas[fila][columna] != null && tableroFichas[fila][columna].getNameFigure() == "[♘]") {
                        amenaza = true;
                        break;
                    }
                }
            }

            // PEONES
            int[] filaPeones = {-1, -1};
            int[] columnaPeones = {-1, 1};
            for (int i = 0; i < 2; i++) {
                int fila = filarey + filaPeones[i];
                int columna = columnarey + columnaPeones[i];
                if (fila >= 0 && fila <= 7 && columna >= 0 && columna <= 7) { // verifica que la posición sea válida en el tablero
                    if (tableroFichas[fila][columna] != null && tableroFichas[fila][columna].getNameFigure() == "[♙]") {
                        amenaza = true;
                        break;
                    }
                }
            }

            return amenaza;
        }
        // CABALLO
        int[][] posicionesCaballo = { { filarey - 1, columnarey - 2 }, { filarey - 2, columnarey - 1 }, { filarey - 2, columnarey + 1 },
                { filarey - 1, columnarey + 2 }, { filarey + 1, columnarey + 2 }, { filarey + 2, columnarey + 1 },
                { filarey + 2, columnarey - 1 }, { filarey + 1, columnarey - 2 } };
        for (int i = 0; i < posicionesCaballo.length; i++) {
            int f = posicionesCaballo[i][0];
            int c = posicionesCaballo[i][1];
            if (f >= 0 && f <= 7 && c >= 0 && c <= 7) {
                if (tableroFichas[f][c] != null && tableroFichas[f][c].getNameFigure() == "[♘]") {
                    amenaza = true;
                    break;
                }
            }
        }

        // PEON
        if (filarey != 7 && columnarey != 0) { // ataques peón izquierda
            if (tableroFichas[filarey + 1][columnarey - 1] != null
                    && tableroFichas[filarey + 1][columnarey - 1].getNameFigure() == "[♙]") {
                amenaza = true;
            }
        }
        if (filarey != 7 && columnarey != 7) { // ataques peón derecha
            if (tableroFichas[filarey + 1][columnarey + 1] != null
                    && tableroFichas[filarey + 1][columnarey + 1].getNameFigure() == "[♙]") {
                amenaza = true;
            }
        }
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) { // busca al rey en el tablero
                    if (tableroFichas[i][j] != null && tableroFichas[i][j].getNameFigure() == "[♔]") {
                        filarey = i;
                        columnarey = j;
                        break;
                    }
                }
            }

            // VERTICALES (solo torre y reina)
            if (filarey != 0) {
                for (int i = filarey - 1, j = columnarey; i >= 0; i--) { // busca vertical arriba, se restan las filas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♜]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7) {
                for (int i = filarey + 1, j = columnarey; i <= 7; i++) { // busca vertical abajo, se suman las filas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♜]"
                            || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }

            // HORIZONTALES (solo torre y reina)
            if (columnarey != 0) {
                for (int i = filarey, j = columnarey - 1; j >= 0; j--) { // busca horizontal izquierda, se restan las columnas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♜]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (columnarey != 7) {
                for (int i = filarey, j = columnarey + 1; j <= 7; j++) { // busca horizontal derecha, se suman las columnas
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♜]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            // DIAGONALES (solo alfil y reina)
            if (filarey != 0 && columnarey != 0) {
                for (int i = filarey - 1, j = columnarey - 1; i >= 0 && j >= 0; i--, j--) { // busca diagonal izquierda arriba
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♝]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 0 && columnarey != 7) {
                for (int i = filarey - 1, j = columnarey + 1; i >= 0 && j <= 7; i--, j++) { // busca diagonal derecha arriba
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♝]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7 && columnarey != 0) {
                for (int i = filarey + 1, j = columnarey - 1; i <= 7 && j >= 0; i++, j--) { // busca diagonal izquierda abajo
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♝]" || tableroFichas[i][j].getNameFigure() == "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }
            if (filarey != 7 && columnarey != 7) {
                for (int i = filarey + 1, j = columnarey + 1; i <= 7 && j <= 7; i++, j++) { // busca diagonal derecha abajo
                    if (tableroFichas[i][j] != null && (tableroFichas[i][j].getNameFigure() == "[♝]" || tableroFichas[i][j].getNameFigure() ==
                            "[♛]")) {
                        amenaza = true;
                        break;
                    }
                }
            }

            // CABALLOS
            int[] filaCaballos = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] columnaCaballos = {1, 2, 2, 1, -1, -2, -2, -1};
            for (int i = 0; i < 8; i++) {
                int fila = filarey + filaCaballos[i];
                int columna = columnarey + columnaCaballos[i];
                if (fila >= 0 && fila <= 7 && columna >= 0 && columna <= 7) { // verifica que la posición sea válida en el tablero
                    if (tableroFichas[fila][columna] != null && tableroFichas[fila][columna].getNameFigure() == "[♞]") {
                        amenaza = true;
                        break;
                    }
                }
            }

            // PEONES
            int[] filaPeones = {-1, -1};
            int[] columnaPeones = {-1, 1};
            for (int i = 0; i < 2; i++) {
                int fila = filarey + filaPeones[i];
                int columna = columnarey + columnaPeones[i];
                if (fila >= 0 && fila <= 7 && columna >= 0 && columna <= 7) { // verifica que la posición sea válida en el tablero
                    if (tableroFichas[fila][columna] != null && tableroFichas[fila][columna].getNameFigure() == "[♟]") {
                        amenaza = true;
                        break;
                    }
                }
            }

            return amenaza;
        }
        // CABALLO
        int[][] posicionesCaballo2 = { { filarey - 1, columnarey - 2 }, { filarey - 2, columnarey - 1 }, { filarey - 2, columnarey + 1 },
                { filarey - 1, columnarey + 2 }, { filarey + 1, columnarey + 2 }, { filarey + 2, columnarey + 1 },
                { filarey + 2, columnarey - 1 }, { filarey + 1, columnarey - 2 } };
        for (int i = 0; i < posicionesCaballo.length; i++) {
            int f = posicionesCaballo2[i][0];
            int c = posicionesCaballo2[i][1];
            if (f >= 0 && f <= 7 && c >= 0 && c <= 7) {
                if (tableroFichas[f][c] != null && tableroFichas[f][c].getNameFigure() == "[♞]") {
                    amenaza = true;
                    break;
                }
            }
        }

        // PEON
        if (filarey != 7 && columnarey != 0 && tableroFichas[filarey + 1][columnarey - 1].getNameFigure() == "[♟]") {
                amenaza = true;
            }
        if (filarey != 7 && columnarey != 7) { // ataques peón derecha
            if (tableroFichas[filarey + 1][columnarey + 1] != null
                    && tableroFichas[filarey + 1][columnarey + 1].getNameFigure() == "[♟]") {
                amenaza = true;
            }
        }
        return amenaza;
    }

}