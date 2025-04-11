package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Card inserted successfully");
        atm.atmState = new HasCardState();
    }

    @Override
    public boolean receivePin(ATMMachine atm, int receivedPin, User user) {
        System.out.println("Enter card first");
        return false;
    }

    @Override
    public OperationType selectOperation(ATMMachine atm) {
        System.out.println("Insert card first");
        return null;
    }

    @Override
    public void cashWithdrawl(ATMMachine atm, User user, int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cashWithdrawl'");
    }

    @Override
    public void checkBalance(ATMMachine atm, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkBalance'");
    }

    @Override
    public void collectCard(ATMMachine atm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'collectCard'");
    }
}
