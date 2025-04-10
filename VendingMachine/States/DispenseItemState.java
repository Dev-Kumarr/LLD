package States;

import Models.Item;
import Models.VendingMachine;

public class DispenseItemState implements MachineState {

    @Override
    public void onEnterCashButtonClick(VendingMachine machine) {

    }

    @Override
    public void insertCoin(VendingMachine machine) {

    }

    @Override
    public int getFullRefund(VendingMachine machine) {
        return 0;
    }

    @Override
    public void onSelectItemButtonClick(VendingMachine machine) {

    }

    @Override
    public Item selectItem(VendingMachine machine) {
        return null;
    }

    @Override
    public int getChange(VendingMachine machine, int amount) {
        return amount;
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Item Dispatched");
    }

}
