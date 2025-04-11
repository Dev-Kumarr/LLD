package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;

public class TransactionCompleteState implements ATMState {

    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Card is already inserted, please take it out");
    }

    @Override
    public boolean receivePin(ATMMachine atm, int receivedPin, User user) {
        System.out.println("Reinsert card then enter pin");
        return false;
    }

    @Override
    public OperationType selectOperation(ATMMachine atm) {
        System.out.println("Reinsert card and then select operation");
        return null;
    }

    @Override
    public void cashWithdrawl(ATMMachine atm, User user, int amount) {
        System.out.println("Reinsert card to withdraw cash");
    }

    @Override
    public void checkBalance(ATMMachine atm, User user) {
        System.out.println("Reinsert card to check balance");
    }

    @Override
    public void collectCard(ATMMachine atm) {
        System.out.println("Please collect your card");
        atm.atmState = new IdleState();
    }

}
