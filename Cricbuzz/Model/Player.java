package Model;

import Enums.PlayerType;

public class Player {
    Person person;

    PlayerType playerType;

    BattingScoreCard playerBattingScoreCard;
    BallingScoreCard playerBallingScoreCard;

    public Player(Person person, PlayerType playerType){
        this.person = person;
        this.playerType = playerType;
        playerBattingScoreCard = new BattingScoreCard();
        playerBallingScoreCard = new BallingScoreCard();
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public BattingScoreCard getPlayerBattingScoreCard() {
        return playerBattingScoreCard;
    }

    public void setPlayerBattingScoreCard(BattingScoreCard playerScoreCard) {
        this.playerBattingScoreCard = playerScoreCard;
    }

    public BallingScoreCard getPlayerBallingScoreCard() {
        return playerBallingScoreCard;
    }

    public void setPlayerBallingScoreCard(BallingScoreCard playerBallingScoreCard) {
        this.playerBallingScoreCard = playerBallingScoreCard;
    }
}
