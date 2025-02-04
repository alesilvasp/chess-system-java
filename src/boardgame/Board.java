package boardgame;

import exceptions.BoardException;

public class Board {

    private int rows;
    private int colunmns;
    private Piece[][] pieces;

    public Board(int rows, int colunmns) {
        if (rows < 1 || colunmns < 1) {
            throw new BoardException("Error creating a board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.colunmns = colunmns;
        pieces = new Piece[rows][colunmns];
    }

    public int getRows() {
        return rows;
    }

    public int getColunmns() {
        return colunmns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece (Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        } 
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;


    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < colunmns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }



}
