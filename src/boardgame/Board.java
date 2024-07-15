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

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

}
