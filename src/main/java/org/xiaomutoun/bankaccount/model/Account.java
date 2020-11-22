package org.xiaomutoun.bankaccount.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int id;
    private String name;
    private int balance;
    private List<CashMovement> movementList;

    public Account() {}

    public Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.movementList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<CashMovement> getMovementList() {
        return movementList;
    }

    public void addCashMovement(CashMovement cashMovement) {
        movementList.add(cashMovement);
    }
}
