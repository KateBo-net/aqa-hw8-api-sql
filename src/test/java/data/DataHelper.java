package data;

import java.util.Random;

public class DataHelper {

    public static String generateCardNumber(String number) {
        return "5559 0000 0000 " + number.substring(number.length() - 4);
    }

    public static int generateAmount(int balance){
        return new Random().nextInt(balance)+1;
    }
}
