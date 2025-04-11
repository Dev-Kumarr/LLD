package AtmLLD;

public class User {
    public String name;
    public Card card;
    public BankAccount account;

    public User(String name, Card card, BankAccount account) {
        this.name = name;
        this.card = card;
        this.account = account;
    }
}
