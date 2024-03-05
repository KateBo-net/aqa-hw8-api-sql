package data;

public class TransferInfo {
    private String from;
    private String to;
    private int amount;

    public TransferInfo(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }
}
