package AtmLLD;

public class Card {
    public int cardNumber;
    public static int ATM_PIN;

    public Card(int cardNumber, int ATM_PIN) {
        this.cardNumber = cardNumber;
        this.ATM_PIN = ATM_PIN;
    }
}
