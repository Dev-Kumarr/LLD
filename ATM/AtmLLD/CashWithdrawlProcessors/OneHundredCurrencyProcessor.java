package AtmLLD.CashWithdrawlProcessors;

import AtmLLD.ATMMachine;

public class OneHundredCurrencyProcessor extends CashWithdrawlProcessor {
    public OneHundredCurrencyProcessor(CashWithdrawlProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void getCurrency(ATMMachine atm, int amount) {
        if (amount <= 0) {
            return;
        }

        int currencyCount = amount / 100;
        if (currencyCount <= atm.oneHundredCurrencyCount) {
            atm.oneHundredCurrencyCount -= currencyCount;
            System.out.println(currencyCount + " Notes of 100 rupees");
            super.getCurrency(atm, amount % 100);
        } else {
            super.getCurrency(atm, amount);
        }
    }
}
