package Model;

import java.util.List;
import java.util.Random;

import Enums.BallType;
import Enums.RunType;
import Enums.WicketType;

public class Over {
    List<Ball> balls;

    int deliveryCount;
    int six;
    int four;
    int wickets;

    public Over(){
        deliveryCount = 0;
        six = 0;
        four = 0;
        wickets = 0;
    }

    public void PlayOver(){
        BallType ballType;
        RunType runType;
        boolean isWicket;
        WicketType wicketType;

        while(deliveryCount < 6){
            ballType = getBallType();
            isWicket = getIsWicket();
            runType = isWicket ? RunType.ZERO : getRunType();
            wicketType = isWicket ? getWicketType() : WicketType.NO_WICKET;


            if(ballType == BallType.NORMAL){
                deliveryCount++;
                Ball ball = new Ball(ballType, runType, isWicket, wicketType);
                ball.DeliverBall();
            }
        }
    }

    private BallType getBallType(){
        // assuming that each ball is fare delivery.
        return BallType.NORMAL;
    }

    private RunType getRunType(){
        Random rand = new Random();
        // getting a number between 0 to 8;
        int run = rand.nextInt(9);
        switch(run){
            case 0: return RunType.ZERO;
            case 1: return RunType.ONE;
            case 2: return RunType.TWO;
            case 3: return RunType.THREE;
            case 4: return RunType.FOUR;
            case 5: return RunType.FIVE;
            case 6: return RunType.SIX;
            case 7: return RunType.NO_BALL_RUN;
            case 8: return RunType.WIDE_BALL_RUN;
        }
        return RunType.ZERO;
    }

    private boolean getIsWicket(){
        Random random = new Random();
        float num = random.nextFloat();

        return num < 0.5;
    }

    private WicketType getWicketType(){
        Random random = new Random();
        float num = random.nextFloat();

        if(num < 0.5) return WicketType.CATCH_OUT;
        if(num < 0.8) return WicketType.RUN_OUT;
        return WicketType.HIT_WICKET;
    }

    //Getters and Setters
    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public int getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(int deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public int getSix() {
        return six;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public int getFour() {
        return four;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }
}
