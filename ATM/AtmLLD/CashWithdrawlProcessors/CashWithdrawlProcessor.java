package AtmLLD.CashWithdrawlProcessors;

import AtmLLD.ATMMachine;

public abstract class CashWithdrawlProcessor {
    public CashWithdrawlProcessor nextProcessor;
    public static int currencyAvailable;

    public CashWithdrawlProcessor(CashWithdrawlProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void getCurrency(ATMMachine atm, int amount) {
        if (nextProcessor == null) {
            return;
        }
        nextProcessor.getCurrency(atm, amount);
    }
}
