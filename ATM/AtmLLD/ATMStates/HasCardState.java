package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;

public class HasCardState implements ATMState {

    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Card is already inserted");
    }

    @Override
    public boolean receivePin(ATMMachine atm, int receivedPin, User user) {
        if (receivedPin == user.card.ATM_PIN) {
            System.out.println("PIN matched");
            return true;
        }
        System.out.println("Pin mismatched " + receivedPin + " " + user.card.ATM_PIN);
        return false;
    }

    @Override
    public OperationType selectOperation(ATMMachine atm) {
        return OperationType.CASH_WITHDRAWL;
    }

    @Override
    public void cashWithdrawl(ATMMachine atm, User user, int amount) {
        System.out.println("Select operation first");
    }

    @Override
    public void checkBalance(ATMMachine atm, User user) {
        System.out.println("Select operation first");
    }

    @Override
    public void collectCard(ATMMachine atm) {
        atm.atmState = new IdleState();
    }

}
