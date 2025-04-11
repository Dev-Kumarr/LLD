package SnakeLadderLLD;

import java.util.Random;

public class Dice {
    private int diceCount;
    private int min = 1;
    private int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public Dice(int diceCount, int min, int max) {
        this.diceCount = diceCount;
        this.min = min;
        this.max = max;
    }

    public int Roll() {
        int sum = 0;
        int rolls = 0;
        Random rand = new Random();
        while (rolls < diceCount) {
            sum += rand.nextInt(min, max);
            rolls++;
        }
        return sum;
    }
}
