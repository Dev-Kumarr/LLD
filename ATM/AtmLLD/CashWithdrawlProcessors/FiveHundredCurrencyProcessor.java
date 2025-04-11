package AtmLLD.CashWithdrawlProcessors;

import AtmLLD.ATMMachine;

public class FiveHundredCurrencyProcessor extends CashWithdrawlProcessor {

    public FiveHundredCurrencyProcessor(CashWithdrawlProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void getCurrency(ATMMachine atm, int amount) {
        if (amount <= 0) {
            return;
        }
        int currencyCount = amount / 500;
        if (currencyCount <= atm.fiveHundredCurrencyCount) {
            atm.fiveHundredCurrencyCount -= currencyCount;
            System.out.println(currencyCount + " Notes of 500 rupees");
            super.getCurrency(atm, amount % 500);
        } else {
            super.getCurrency(atm, amount);
        }
    }
}
