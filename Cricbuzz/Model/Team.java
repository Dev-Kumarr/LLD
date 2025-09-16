package Model;

import Controller.BallingController;
import Controller.BattingController;

public class Team {
    private Player captain;

    private BattingController battingController;
    private BallingController ballingController;

    public Team(Player captain, BattingController battingController, BallingController ballingController){
        this.captain = captain;
        this.battingController = battingController;
        this.ballingController = ballingController;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public BattingController getBattingController() {
        return battingController;
    }

    public void setBattingController(BattingController battingController) {
        this.battingController = battingController;
    }

    public BallingController getBallingController() {
        return ballingController;
    }

    public void setBallingController(BallingController ballingController) {
        this.ballingController = ballingController;
    }
}
