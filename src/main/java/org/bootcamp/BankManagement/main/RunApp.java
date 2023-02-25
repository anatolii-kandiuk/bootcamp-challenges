package org.bootcamp.BankManagement.main;

import org.bootcamp.BankManagement.main.pojo.Account;
import org.bootcamp.BankManagement.main.pojo.Checking;
import org.bootcamp.BankManagement.main.pojo.Credit;
import org.bootcamp.BankManagement.main.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RunApp {
    public static void run() {
        AccountRepository repository = new AccountRepository();

        List<Account> aaccounts = Arrays.asList(
          new Checking("A1234B", new BigDecimal("500.00")),
          new Credit("A1234B", new BigDecimal("0.50"))
        );

        aaccounts.forEach(account -> {
            repository.createAccount(account);
        });

        System.out.println();
    }
}
