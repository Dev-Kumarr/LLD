package Model;

import java.util.List;

import Enums.BallType;
import Enums.RunType;
import Enums.WicketType;
import Observables.BallObservable;
import Observers.BallObserver;

public class Ball implements BallObservable{
    BallType ballType;
    RunType runType;

    boolean isWicket;
    WicketType wicketType;

    List<BallObserver> ballObservers;

    public Ball(BallType ballType, RunType runType, boolean isWicket, WicketType wicketType){
        this.ballType = ballType;
        this.runType = runType;
        this.isWicket = isWicket;
        this.wicketType = wicketType;
    }

    public void DeliverBall(){
        Notify();
    }

    public void Notify(){
        for (BallObserver ballObserver : ballObservers) {
            ballObserver.ObserveBall(this);
        }
    }


    // Getters and Setters
    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public boolean isWicket() {
        return isWicket;
    }

    public void setWicket(boolean isWicket) {
        this.isWicket = isWicket;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }
}
