package org.xiaomutoun.bankaccount;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.xiaomutoun.bankaccount.model.CashMovement;
import org.xiaomutoun.bankaccount.service.AccountService;

import java.util.List;

public class AccountTest {

    private static AccountService accountService;

    @BeforeAll
    public static void init() {
        accountService = new AccountService();
    }

    @Test
    public void testSaveAndRetrieve() {
        CashMovement cm1 = new CashMovement(101, "save", 300);
        CashMovement cm2 = new CashMovement(101, "save", 900);
        CashMovement cm3 = new CashMovement(101, "retrieve", 400);
        CashMovement cm4 = new CashMovement(101, "retrieve", 100);
        CashMovement cm5 = new CashMovement(101, "retrieve", 200);
        accountService.saveOrRetrieveMoney(cm1);
        accountService.saveOrRetrieveMoney(cm2);
        accountService.saveOrRetrieveMoney(cm3);
        accountService.saveOrRetrieveMoney(cm4);
        accountService.saveOrRetrieveMoney(cm5);
        List<CashMovement> cashMovements = accountService.getHistory(101);
        Assertions.assertEquals(cashMovements.size(), 5);
        Assertions.assertEquals(cashMovements.get(4).getBalance(), 500);
    }
}
