package SnakeLadderLLD;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    public Board board;
    public Queue<Player> players;
    public Dice dice;

    public Game() {
        InitializeGame();
    }

    private void InitializeGame() {
        board = new Board(10, 2, 3);
        Player p1 = new Player("p1", "P1");
        Player p2 = new Player("p2", "P2");
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        dice = new Dice(1);
    }

    public void StartGame() {
        boolean isWinnerDecided = false;

        while (!isWinnerDecided) {
            Player playerInTurn = players.poll();
            System.out
                    .println(playerInTurn.playerName + " is rolling dice at position " + playerInTurn.currentPosition);
            int steps = dice.Roll();
            playerInTurn.currentPosition += steps;
            System.out.println("Number on dice " + steps);

            playerInTurn.currentPosition = board.GetJumpOnCell(playerInTurn.currentPosition);
            System.out.println("Final position " + playerInTurn.currentPosition);
            if (playerInTurn.currentPosition >= board.size * board.size - 1) {
                isWinnerDecided = true;
                System.out.println("Winner is : " + playerInTurn.playerName);
            }

            players.add(playerInTurn);
        }
    }
}
