import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public Queue<Player> playerTurnQueue;
    public Board board;
    public List<Player> players;

    public static final Scanner scanner = new Scanner(System.in);

    public Game() {
        InitializeGame();
    }

    public void InitializeGame() {
        int size = 3;
        this.board = new Board(size);

        playerTurnQueue = new LinkedList<>();

        Player p1 = new Player(PieceType.X, "Player1");
        Player p2 = new Player(PieceType.O, "Player2");

        playerTurnQueue.add(p1);
        playerTurnQueue.add(p2);
    }

    public String StartGame() {
        boolean isWinnerDecided = false;
        PrintBoard();
        while (!isWinnerDecided) {
            Player playerInTurn = playerTurnQueue.peek();
            int row, col;
            System.out.println("Enter row and column");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (board.addPiece(playerInTurn.piece, row, col)) {
                board.board[row][col] = playerInTurn.piece;
                PrintBoard();
                playerTurnQueue.add(playerInTurn);
                playerTurnQueue.poll();
                if (isWinner(playerInTurn.piece, row, col)) {
                    isWinnerDecided = true;
                    return playerInTurn.name;
                }
            } else {
                System.out.println("Wrong input, try again");
            }

            if (!board.hasFreeSpace()) {
                break;
            }
        }
        return "Tie";
    }

    public void PrintBoard() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                if (board.board[i][j] != null) {
                    System.out.print(board.board[i][j].toString() + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
    }

    public boolean isWinner(PieceType piece, int x, int y) {
        boolean rowWin = true;
        boolean colWin = true;
        boolean leftDiagWin = (x == y);
        boolean rightDiagWin = (x == y);

        // check row
        for (int i = 0; i < board.size; i++) {
            rowWin &= (board.board[x][i] == piece);
        }

        // check col
        for (int i = 0; i < board.size; i++) {
            colWin &= (board.board[i][y] == piece);
        }

        // check left diagonal
        if (leftDiagWin) {
            for (int i = 0; i < board.size; i++) {
                leftDiagWin &= (board.board[i][i] == piece);
            }
        }

        // check right diagonal
        if (rightDiagWin) {
            for (int i = 0; i < board.size; i++) {
                rightDiagWin &= (board.board[i][board.size - i - 1] == piece);
            }
        }

        return (rowWin || colWin || leftDiagWin || rightDiagWin);
    }
}
