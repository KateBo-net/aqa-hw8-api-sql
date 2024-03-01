package data;

public class CardInfo {
    private String id;
    private String number;
    private int balance;

    public CardInfo(String id, String number, int balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }
}
