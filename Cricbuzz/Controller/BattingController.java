package Controller;

import java.util.List;

import Model.Player;

public class BattingController {
    List<Player> playing11;
    
    Player striker;
    Player nonStriker;

    public BattingController(List<Player> playing11, Player striker, Player nonStriker){
        this.playing11 = playing11;
        this.nonStriker = nonStriker;
        this.striker = striker;
    }

    public List<Player> getPlaying11() {
        return playing11;
    }

    public void setPlaying11(List<Player> playing11) {
        this.playing11 = playing11;
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }
}
