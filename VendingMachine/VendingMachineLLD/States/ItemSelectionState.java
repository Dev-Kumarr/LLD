package States;

import java.util.Random;

import Models.Coin;
import Models.Item;
import Models.VendingMachine;

public class ItemSelectionState implements MachineState {

    @Override
    public void onEnterCashButtonClick(VendingMachine machine) {
        System.out.println("Select item");
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("select item");
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
        return;
    }

    @Override
    public Item selectItem(VendingMachine machine) {
        System.out.println("Selecting item");
        Random rand = new Random();
        int itemIndex = rand.nextInt(0, machine.inventory.items.length - 1);
        Item itemSelected = machine.inventory.items[itemIndex];
        int moneyReceived = 0;
        for (Coin coin : machine.coins) {
            moneyReceived += coin.value;
        }
        if (itemSelected.price <= moneyReceived && !itemSelected.isSold) {
            getChange(machine, moneyReceived - itemSelected.price);
            return itemSelected;
        }

        if (itemSelected.isSold) {
            System.out.println("Item is sold out, take your refund");
        }
        System.out.println("cant buy " + itemSelected.itemType.toString());
        machine.state = new IdleState();
        return null;
    }

    @Override
    public int getChange(VendingMachine machine, int amount) {
        System.out.println("giving changes");
        machine.state = new DispenseItemState();
        return amount;
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("select item first");
    }

}
