public class Movement {
    private Position startPos;
    private Position endPos;
    private boolean esVertical(){
        boolean respuesta = false;
        if (startPos.getColumna()==endPos.getColumna())
            respuesta= true;
        return respuesta;
        //return startPos.getColumna()==endPos.getColumna();
    }
    private boolean esHorizontal(){
        return true;
    }
    private boolean esDiagonal(){
        return true;
    }
}
