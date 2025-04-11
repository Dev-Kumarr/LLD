package TicTacToeLLD;

public class Board {
    public int size;
    public PieceType[][] board;
    public long freeSpaces;

    public Board(int size) {
        this.size = size;
        this.board = new PieceType[size][size];
        this.freeSpaces = (long) size * size;
    }

    public boolean addPiece(PieceType piece, int i, int j) {
        if (i >= size || j >= size || i < 0 || j < 0) {
            return false;
        }
        if (this.board[i][j] != null) {
            return false;
        }
        board[i][j] = piece;
        --freeSpaces;
        return true;
    }

    public boolean hasFreeSpace() {
        return freeSpaces > 0;
    }
}
