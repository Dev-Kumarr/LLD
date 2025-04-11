package AtmLLD;

import AtmLLD.ATMStates.ATMState;

public class ATMMachine {
    public static int twoThousandCurrencyCount;
    public static int fiveHundredCurrencyCount;
    public static int oneHundredCurrencyCount;
    public ATMState atmState;

    public ATMMachine(ATMState atmState, int twoThousandCurrencyCount, int fiveHundredCurrencyCount,
            int oneHundredCurrencyCount) {
        this.atmState = atmState;
        this.twoThousandCurrencyCount = twoThousandCurrencyCount;
        this.fiveHundredCurrencyCount = fiveHundredCurrencyCount;
        this.oneHundredCurrencyCount = oneHundredCurrencyCount;
    }
}
