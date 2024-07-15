package boardgame;

public class Board {

    private int rows;
    private int colunmns;
    private Piece[][] pieces;

    public Board(int rows, int colunmns) {
        this.rows = rows;
        this.colunmns = colunmns;
        pieces = new Piece[rows][colunmns];
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColunmns(int colunmns) {
        this.colunmns = colunmns;
    }

    public int getRows() {
        return rows;
    }

    public int getColunmns() {
        return colunmns;
    }

}
