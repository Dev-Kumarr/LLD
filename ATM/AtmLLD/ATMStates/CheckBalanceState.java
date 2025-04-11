package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;

public class CheckBalanceState implements ATMState {

    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Checking balance, can't insert card");
    }

    @Override
    public boolean receivePin(ATMMachine atm, int receivedPin, User user) {
        System.out.println("Checking balance, can't receive pin");
        return false;
    }

    @Override
    public OperationType selectOperation(ATMMachine atm) {
        System.out.println("Checking balance, can't select operation");
        return null;
    }

    @Override
    public void cashWithdrawl(ATMMachine atm, User user, int amount) {
        System.out.println("Checking balance, can't withdraw cash");
    }

    @Override
    public void checkBalance(ATMMachine atm, User user) {
        System.out.println("Your account balance is " + user.account.balance);
        atm.atmState = new TransactionCompleteState();
    }

    @Override
    public void collectCard(ATMMachine atm) {
        System.out.println("Checking balance, can't remove card");
    }

}
