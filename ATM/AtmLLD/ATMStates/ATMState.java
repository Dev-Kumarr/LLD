package AtmLLD.ATMStates;

import AtmLLD.ATMMachine;
import AtmLLD.OperationType;
import AtmLLD.User;

public interface ATMState {
    public void insertCard(ATMMachine atm);

    public boolean receivePin(ATMMachine atm, int receivedPin, User user);

    public OperationType selectOperation(ATMMachine atm);

    public void cashWithdrawl(ATMMachine atm, User user, int amount);

    public void checkBalance(ATMMachine atm, User user);

    public void collectCard(ATMMachine atm);

}
