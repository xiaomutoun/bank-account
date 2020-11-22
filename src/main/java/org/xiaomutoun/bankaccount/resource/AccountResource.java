package org.xiaomutoun.bankaccount.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xiaomutoun.bankaccount.model.CashMovement;
import org.xiaomutoun.bankaccount.service.AccountService;

import java.util.List;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String index() {
        return "Welcome to the simple bank system!";
    }

    @PostMapping(path = "/operate")
    public void saveOrRetrieveMoney(@RequestBody CashMovement cashMovement) {
        accountService.saveOrRetrieveMoney(cashMovement);
    }


    @GetMapping(path = "/history/{id}")
    public List<CashMovement> getHistory(@PathVariable int id) {
        return accountService.getHistory(id);
    }
}
