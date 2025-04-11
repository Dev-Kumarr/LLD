package Models;

import java.util.List;

import States.MachineState;

public class VendingMachine {
    public Inventory inventory;
    public List<Coin> coins;
    public MachineState state;
}
