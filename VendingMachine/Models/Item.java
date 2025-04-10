package Models;

public class Item {
    public String id;
    public ItemType itemType;
    public int price;
    public boolean isSold;

    public Item(String id, ItemType itemType, int price, boolean isSold) {
        this.id = id;
        this.itemType = itemType;
        this.price = price;
        this.isSold = isSold;
    }
}
