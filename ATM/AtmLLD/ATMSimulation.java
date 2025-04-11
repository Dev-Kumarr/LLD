package AtmLLD;

import AtmLLD.ATMStates.ATMState;
import AtmLLD.ATMStates.CashWithdrawlState;
import AtmLLD.ATMStates.CheckBalanceState;
import AtmLLD.ATMStates.IdleState;

public class ATMSimulation {
    public ATMMachine atm;
    public User user;

    public ATMSimulation() {
        initialize();
    }

    public void initialize() {
        Card card = new Card(10012002, 1001);
        BankAccount account = new BankAccount(5200);
        this.user = new User("Dev", card, account);

        ATMState atmState = new IdleState();
        this.atm = new ATMMachine(atmState, 1, 12, 2);

        startSimulation();
    }

    public void startSimulation() {
        atm.atmState.insertCard(atm);

        if (!atm.atmState.receivePin(atm, 1001, user)) {
            System.out.println("Incorrect Pin, please collect your card and try again");
            atm.atmState = new IdleState();
            return;
        }

        OperationType operationType = atm.atmState.selectOperation(atm);

        switch (operationType) {
            case CHECK_BALANCE:
                atm.atmState = new CheckBalanceState();
                atm.atmState.checkBalance(atm, user);
                break;

            case CASH_WITHDRAWL:
                atm.atmState = new CashWithdrawlState();
                atm.atmState.cashWithdrawl(atm, user, 2600);
                break;
            default:
                System.out.println("Invalid operation, collect your card");
                return;
        }

        atm.atmState.collectCard(atm);
    }
}
