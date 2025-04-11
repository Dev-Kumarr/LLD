package States;

import java.util.LinkedList;
import java.util.List;

import Models.Coin;
import Models.Item;
import Models.VendingMachine;

public class ReceiveMoneyState implements MachineState {

    @Override
    public void onEnterCashButtonClick(VendingMachine machine) {

    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Inserting coins");
        List<Coin> coins = new LinkedList<>();
        coins.add(Coin.FIFTY);
        coins.add(Coin.TWENTY);
        machine.coins = coins;
    }

    @Override
    public int getFullRefund(VendingMachine machine) {
        int sum = 0;
        for (Coin coin : machine.coins) {
            sum += coin.value;
        }
        machine.state = new IdleState();
        return sum;
    }

    @Override
    public void onSelectItemButtonClick(VendingMachine machine) {
        machine.state = new ItemSelectionState();
    }

    @Override
    public Item selectItem(VendingMachine machine) {
        System.out.println("Press select item button to select item");
        return null;
    }

    @Override
    public int getChange(VendingMachine machine, int amount) {
        return amount;
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("select item first");
    }

}
