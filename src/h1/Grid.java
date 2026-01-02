package h1;

public class Grid {
    private Cell[][] gridArray;

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        this.gridArray = new Cell[gridRows][gridCols];

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                this.gridArray[i][j] = new Cell(i, j);
            }
        }

        for (Cell c : cells) {
            int r = c.getIndexRow();
            int col = c.getIndexCol();

            if(r >= 0 && r < gridRows && col >= 0 && col < gridCols) {
                this.gridArray[r][col].setAlive(true);
            }
                }
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                this.gridArray[i][j].countLivingNeighbors(this.gridArray);
            }
        }
    }
    public void computeNextGen(){

    }
}

