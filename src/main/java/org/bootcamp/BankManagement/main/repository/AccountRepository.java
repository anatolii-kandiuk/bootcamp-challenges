package org.bootcamp.BankManagement.main.repository;

import org.bootcamp.BankManagement.main.pojo.Account;
import org.bootcamp.BankManagement.main.pojo.Checking;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

    private Map<String, Account> datastore = new HashMap<>();

    public void createAccount(Account account) {
        this.datastore.put(account.getId(), account.clone());
    }

    public Account retrieveAccount(String id) {
        return null;
    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(String id) {

    }
}
