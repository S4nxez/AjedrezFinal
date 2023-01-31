package Mecanicas;

public class Movement {
    private Position startPos;
    private Position endPos;

    public Movement(Position startPos, Position endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Movement(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) {
        startPos = new Position(filaInicial, columnaInicial);
        endPos = new Position(filaFinal, columnaFinal);
    }

    public boolean esVertical() {
        boolean respuesta = false;
        if (startPos.getColumna() == endPos.getColumna())
            respuesta = true;
        return respuesta;
        //return startPos.getColumna()==endPos.getColumna();
    }
    public boolean esHorizontal() {
       boolean respuesta = false;
        if (startPos.getFila() == endPos.getFila())
            respuesta = true;
        return respuesta;
    }
    public Position getstartPos(){return startPos;}
    public Position getendPos(){return endPos;}
    public boolean esDiagonal() {
        return Math.abs(saltoVertical()) == Math.abs(saltoHorizontal());
    }
    public int saltoVertical() {
        return (endPos.getFila() - startPos.getFila());
    }
    public int saltoHorizontal() {
        return endPos.getColumna() - startPos.getColumna();
    }
}
