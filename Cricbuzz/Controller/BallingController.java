package Controller;

import java.util.Queue;

import Model.Player;

public class BallingController {
    Queue<Player> ballers;

    Player currentBaller;
    Player wicketKeeper;

    public Queue<Player> getBallers() {
        return ballers;
    }

    public void setBallers(Queue<Player> ballers) {
        this.ballers = ballers;
    }

    public Player getCurrentBaller() {
        return currentBaller;
    }

    public void setCurrentBaller(Player currentBaller) {
        this.currentBaller = currentBaller;
    }

    public Player getWicketKeeper() {
        return wicketKeeper;
    }

    public void setWicketKeeper(Player wicketKeeper) {
        this.wicketKeeper = wicketKeeper;
    }
}
