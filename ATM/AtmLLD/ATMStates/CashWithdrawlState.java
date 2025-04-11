package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;
import AtmLLD.CashWithdrawlProcessors.CashWithdrawlProcessor;
import AtmLLD.CashWithdrawlProcessors.FiveHundredCurrencyProcessor;
import AtmLLD.CashWithdrawlProcessors.OneHundredCurrencyProcessor;
import AtmLLD.CashWithdrawlProcessors.TwoThousandCurrencyProcessor;

public class CashWithdrawlState implements ATMState {

    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Withdrawl in progress, can't insert card");
    }

    @Override
    public boolean receivePin(ATMMachine atm, int receivedPin, User user) {
        System.out.println("Withdrawl in progress, can't insert pin");
        return false;
    }

    @Override
    public OperationType selectOperation(ATMMachine atm) {
        System.out.println("Withdrawl in progress, can't select operation");
        return null;
    }

    @Override
    public void cashWithdrawl(ATMMachine atm, User user, int amount) {
        if (amount > user.account.balance) {
            System.out.println("You don't have enough amount in your account");
            atm.atmState = new TransactionCompleteState();
            return;
        }
        System.out.println("Please collect your cash");

        CashWithdrawlProcessor cashWithdrawlProcessor = new TwoThousandCurrencyProcessor(
                new FiveHundredCurrencyProcessor(new OneHundredCurrencyProcessor(null)));

        cashWithdrawlProcessor.getCurrency(atm, amount);
        user.account.balance -= amount;
        atm.atmState = new TransactionCompleteState();
    }

    @Override
    public void checkBalance(ATMMachine atm, User user) {
        System.out.println("Withdrawl in process, can't check balance currently");
    }

    @Override
    public void collectCard(ATMMachine atm) {
        System.out.println("Withdrawl in progress, can't take card out");
    }

}
