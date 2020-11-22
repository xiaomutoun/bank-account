package org.xiaomutoun.bankaccount.service;

import org.springframework.stereotype.Service;
import org.xiaomutoun.bankaccount.model.Account;
import org.xiaomutoun.bankaccount.model.CashMovement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accountList;

    public AccountService() {
        accountList = new ArrayList<>();
        accountList.add(new Account(101, "Alice", 0));
        accountList.add(new Account(102, "Bob", 0));
        accountList.add(new Account(103, "David", 0));
    }

    public List<CashMovement> getHistory(int id) {
        Account account = getAccount(id);
        return account.getMovementList();
    }

    public void saveOrRetrieveMoney(CashMovement cashMovement) {
        Account account = getAccount(cashMovement.getAccountId());
        cashMovement.setId(generateCashMovementId(account));
        if ("save".equals(cashMovement.getType())) {
            account.setBalance(account.getBalance() + cashMovement.getAmount());
        } else if ("retrieve".equals(cashMovement.getType())) {
            if (account.getBalance() < cashMovement.getAmount()) {
                throw new IllegalArgumentException("No enough money to retrieve: " + cashMovement.getAmount());
            }
            account.setBalance(account.getBalance() - cashMovement.getAmount());
        } else {
            throw new IllegalArgumentException("Wrong movement type: " + cashMovement.getType());
        }
        cashMovement.setBalance(account.getBalance());
        cashMovement.setDate(new Date());
        account.addCashMovement(cashMovement);
    }

    private Account getAccount(int id) {
        Account result = null;
        for (Account account: accountList) {
            if (account.getId() == id) {
                result = account;
            }
        }
        return result;
    }

    private int generateCashMovementId(Account account) {
        return account.getMovementList().size() + 100;
    }
}
