package org.bootcamp.BankManagement.main;

import org.bootcamp.BankManagement.main.constant.AccountType;
import org.bootcamp.BankManagement.main.constant.Transaction;
import org.bootcamp.BankManagement.main.pojo.Account;
import org.bootcamp.BankManagement.main.pojo.Checking;
import org.bootcamp.BankManagement.main.pojo.Credit;
import org.bootcamp.BankManagement.main.repository.AccountRepository;
import org.bootcamp.BankManagement.main.service.AccountService;
import org.bootcamp.BankManagement.main.service.CheckingService;
import org.bootcamp.BankManagement.main.service.CreditService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class RunApp {

    private static Path[] paths = new Path[] {
            Paths.get("/home/anatolii/Education/Udemy/Java/JavaCore/Bootcamp/bootcamp-challenges/src/main/java/org/bootcamp/BankManagement/main/data/accounts.txt"),
            Paths.get("/home/anatolii/Education/Udemy/Java/JavaCore/Bootcamp/bootcamp-challenges/src/main/java/org/bootcamp/BankManagement/main/data/transaction.txt")
    };

    private static AccountRepository repository = new AccountRepository();

    private static CheckingService checkingService = new CheckingService(repository);

    private static CreditService creditService = new CreditService(repository);

    public static void run() {
        try {
            loadAccounts();
            applyTransactions();
            finalTest();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void loadAccounts() throws IOException {
        Files.lines(paths[0])
                .forEach(line -> {
                    String[] words = line.split(" ");

                    if (words[0].equals(AccountType.CHECKING.toString())) {
                        checkingService.createAccount(new Checking(words[1], new BigDecimal(words[2])));
                    } else {
                        creditService.createAccount(new Credit(words[1], new BigDecimal(words[2])));
                    }
                });
    }

    private static void applyTransactions() throws IOException {
        Files.lines(paths[1])
                .forEach(line -> {
                    String[] words = line.split(" ");

                    Boolean isChecking = words[0].equals(AccountType.CHECKING.toString());

                    AccountService accountService = isChecking ? checkingService : creditService;

                    Transaction transaction = Transaction.valueOf(words[2]);

                    if (transaction.equals(Transaction.DEPOSIT)) {
                        accountService.deposit(words[1], new BigDecimal(words[3]));
                    } else {
                        accountService.withdraw(words[1], new BigDecimal(words[3]));
                    }
                });
    }

    private static void finalTest() throws IOException {
        System.out.println("Account A1234B Balance: " + checkingService.retrieveAccount("A1234B").getBalance());
        System.out.println("Account E3456F Balance: " + checkingService.retrieveAccount("E3456F").getBalance());
        System.out.println("Account I5678J Balance: " + checkingService.retrieveAccount("I5678J").getBalance());
        System.out.println("Account C2345D Credit: " + creditService.retrieveAccount("C2345D").getCredit());
        System.out.println("Account G4567H Credit: " + creditService.retrieveAccount("G4567H").getCredit());
    }

}
