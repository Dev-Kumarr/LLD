package States;

import Models.Item;
import Models.VendingMachine;

public interface MachineState {
    public void onEnterCashButtonClick(VendingMachine machine);

    public void insertCoin(VendingMachine machine);

    public int getFullRefund(VendingMachine machine);

    public void onSelectItemButtonClick(VendingMachine machine);

    public Item selectItem(VendingMachine machine);

    public int getChange(VendingMachine machine, int amount);

    public void dispenseItem(VendingMachine machine);
}