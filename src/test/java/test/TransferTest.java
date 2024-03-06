package test;

import data.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static api.RequestHelper.*;
import static data.DataHelper.*;
import static data.SQLHelper.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {

    @AfterAll
    public static void tearDownAll() {
        cleanDB();
    }

    @Test
    public void shouldTransferMoney() {
        AuthInfo user = new AuthInfo("vasya", "qwerty123");
        postAuth(user);
        VerifyInfo verifyInfo = new VerifyInfo(user.getLogin(), getVerificationCode());
        String token = postVerify(verifyInfo);
        List<CardInfo> cardList = getCards(token);

        int balanceFrom = cardList.get(0).getBalance();
        int balanceTo = cardList.get(1).getBalance();
        int amount = generateAmount(balanceFrom);
        String from = generateCardNumber(cardList.get(0).getNumber());
        String to = generateCardNumber(cardList.get(1).getNumber());
        TransferInfo transfer = new TransferInfo(from, to, amount);
        postTransfer(token, transfer);
        List<CardInfo> cardListResult = getCards(token);
        assertAll(
                () -> assertEquals(balanceFrom - amount, cardListResult.get(0).getBalance()),
                () -> assertEquals(balanceTo + amount, cardListResult.get(1).getBalance())
        );
    }
}
