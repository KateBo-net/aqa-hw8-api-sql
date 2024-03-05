package data;

import lombok.Value;

@Value
public class TransferInfo {
    private String from;
    private String to;
    private int amount;
}
