package org.bootcamp.BankManagement.main.service;

import org.bootcamp.BankManagement.main.pojo.Credit;
import org.bootcamp.BankManagement.main.repository.AccountRepository;

import java.math.BigDecimal;

public class CreditService implements AccountService {
    private AccountRepository accountRepository;

    public CreditService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Credit account) {
        this.accountRepository.createAccount(account);
    }

    public Credit retrieveAccount(String id) {
        return (Credit) this.accountRepository.retrieveAccount(id);
    }

    public void updateAccount(Credit account) {
        this.accountRepository.updateAccount(account);
    }

    public void deleteAccount(String id) {
        this.accountRepository.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        Credit credit = retrieveAccount(id);

        credit.setCredit(credit.getCredit().subtract(amount));

        updateAccount(credit);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        Credit credit = retrieveAccount(id);

        credit.setCredit(credit.getCredit().add(amount));

        updateAccount(credit);
    }
}
