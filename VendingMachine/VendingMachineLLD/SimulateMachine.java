import java.util.LinkedList;

import Models.*;
import States.IdleState;

public class SimulateMachine {
    public VendingMachine machine;

    public void init() {
        machine = new VendingMachine();
        machine.state = new IdleState();
        Item[] items = new Item[15];

        // adding items to machine
        for (int i = 0; i < 3; i++) {
            items[i] = new Item(String.valueOf(100 + i), ItemType.CHOCOLATE, 90, false);
        }
        for (int i = 0; i < 3; i++) {
            items[3 + i] = new Item(String.valueOf(200 + i), ItemType.COKE, 30, false);
        }
        for (int i = 0; i < 3; i++) {
            items[6 + i] = new Item(String.valueOf(300 + i), ItemType.PEPSI, 30, false);
        }
        for (int i = 0; i < 3; i++) {
            items[9 + i] = new Item(String.valueOf(400 + i), ItemType.SODA, 40, false);
        }
        for (int i = 0; i < 3; i++) {
            items[12 + i] = new Item(String.valueOf(500 + i), ItemType.WATER, 20, false);
        }

        machine.inventory = new Inventory();
        machine.inventory.items = items;

        machine.coins = new LinkedList<>();
        machine.state.onEnterCashButtonClick(machine);
        machine.state.insertCoin(machine);
        machine.state.onSelectItemButtonClick(machine);

        Item itemSelected = machine.state.selectItem(machine);
        if (itemSelected == null) {
            machine.state.getFullRefund(machine);
            return;
        }
        itemSelected.isSold = true;
        machine.state.dispenseItem(machine);
    }
}
