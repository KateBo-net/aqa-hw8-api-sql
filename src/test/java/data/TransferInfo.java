package data;

public class TransferInfo {
    private String from;
    private String to;
    private int amount;

    public TransferInfo(String from, String to, int amount) {
        this.from = "5559 0000 0000" + from.substring(from.length() - 4);
        this.to = "5559 0000 0000" + to.substring(to.length() - 4);
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
