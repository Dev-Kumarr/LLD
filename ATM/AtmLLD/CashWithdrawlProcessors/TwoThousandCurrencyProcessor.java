package AtmLLD.CashWithdrawlProcessors;

import AtmLLD.ATMMachine;

public class TwoThousandCurrencyProcessor extends CashWithdrawlProcessor {

    public TwoThousandCurrencyProcessor(CashWithdrawlProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void getCurrency(ATMMachine atm, int amount) {
        if (amount <= 0) {
            return;
        }

        int currencyCount = amount / 2000;
        if (currencyCount <= atm.twoThousandCurrencyCount) {
            atm.twoThousandCurrencyCount -= currencyCount;
            System.out.println(currencyCount + " Notes of 2000 rupees");
            super.getCurrency(atm, amount % 2000);
        } else {
            super.getCurrency(atm, amount);
        }
    }

}
