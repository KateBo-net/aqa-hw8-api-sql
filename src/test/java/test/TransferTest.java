package test;

import api.RequestHelper;
import data.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static api.RequestHelper.*;
import static data.SQLHelper.*;

public class TransferTest {

    @AfterAll
    public static void tearDownAll() {
        cleanDB();
    }

    @Test
    public void shouldTransferMoney(){
        int amount = 5000;
        AuthInfo user = new AuthInfo("vasya", "qwerty123");
        postAuth(user);
        VerifyInfo verifyInfo = new VerifyInfo(user.getLogin(), getVerificationCode());
        String token = postVerify(verifyInfo);
        List<CardInfo> cardList = getCards(token);
        TransferInfo transfer = new TransferInfo(cardList.get(0).getNumber(), cardList.get(1).getNumber(), amount);
        postTransfer(token, transfer);
    }
}
