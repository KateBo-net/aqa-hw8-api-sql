package test;

import data.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static api.RequestHelper.*;
import static data.DataHelper.*;
import static data.SQLHelper.*;

public class TransferTest {

    @AfterAll
    public static void tearDownAll() {
        cleanDB();
    }

    @Test
    public void shouldTransferMoney(){
        AuthInfo user = new AuthInfo("vasya", "qwerty123");
        postAuth(user);
        VerifyInfo verifyInfo = new VerifyInfo(user.getLogin(), getVerificationCode());
        String token = postVerify(verifyInfo);
        List<CardInfo> cardList = getCards(token);
        int amount = cardList.get(0).getBalance();
        String from = generateCardNumber(cardList.get(0).getNumber());
        String to = generateCardNumber(cardList.get(1).getNumber());
        TransferInfo transfer = new TransferInfo(from, to, amount);
        postTransfer(token, transfer);
    }
}
