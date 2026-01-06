package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.currentRow = indexRow;
        this.currentCol = indexCol;
        this.brett = brett;
    }
    public boolean movesOut() {
       Feld feld = this.brett.getBrett()[currentRow][currentCol];
       char richtung = feld.getDirection();
       if (richtung == 'U' && currentRow == 0) {
           return true;
       }
       if (richtung == 'L' && currentCol == 0) {
           return true;
       }
       if(richtung == 'D' && currentRow == this.brett.getDim()-1) {
           return true;
       }
       if(richtung == 'R' && currentCol== this.brett.getDim()-1) {
           return true;
       }
       return false;

    }
    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld aktuellesFeld = this.brett.getBrett()[currentRow][currentCol];
            if (aktuellesFeld.isBoese() == true) {
                continue;
            }
            if (movesOut() == true) {
                continue;
            }
            char richtung = aktuellesFeld.getDirection();
            if (richtung == 'U') {
                currentRow = currentRow -1;
            }
            else if (richtung == 'D') {
                currentRow = currentRow +1;
            }
            else if (richtung == 'L') {
                currentCol = currentCol -1;
            }
            else if (richtung == 'R') {
                currentCol = currentCol +1;
            }
        }
    }
}
