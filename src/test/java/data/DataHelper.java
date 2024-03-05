package data;

public class DataHelper {

    public static String generateCardNumber(String number) {
        return "5559 0000 0000" + number.substring(number.length() - 4);
    }
}
