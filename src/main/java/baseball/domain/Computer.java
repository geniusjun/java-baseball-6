package baseball.domain;

public class Computer {

    private String goalNum;

    private int strike;

    private int ball;

    public String getGoalNum() {
        return goalNum;
    }

    public void setGoalNum(String goalNum) {
        this.goalNum = goalNum;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setBallPlus() {
        this.ball++;
    }

    public void setStrikePlus() {
        this.strike++;
    }


}
