package Model;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    Team battingTeam;
    Team ballingTeam;

    int totalOvers;

    List<Over> overs;

    public Inning(int totalOvers, Team battingTeam, Team ballingTeam){
        this.ballingTeam = ballingTeam;
        this.battingTeam = battingTeam;
        this.totalOvers = totalOvers;

        overs = new ArrayList<Over>();
    }

    public void StartInning(){
        for(int currentOver = 1; currentOver <= totalOvers; currentOver++){
            Over over = new Over();
            over.PlayOver();
            overs.add(over);
        }
    }


    // Getters and Setters
    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBallingTeam() {
        return ballingTeam;
    }

    public void setBallingTeam(Team ballingTeam) {
        this.ballingTeam = ballingTeam;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }
}
