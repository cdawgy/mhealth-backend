package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountService {
    private final ArrayList<Account> listOfAccounts;

    public AccountService(){
        listOfAccounts = new ArrayList<>();
        var parentAccount = Account.builder().accountId("117961479542614585037").accountType("parent").build();
        var therapistAccount = Account.builder().accountId("109020841686505071523").accountType("therapist").build();
        listOfAccounts.add(parentAccount);
        listOfAccounts.add(therapistAccount);
    }

    public Optional<Account> findAccount(String accountId) {
        return listOfAccounts.stream().filter((account -> account.getAccountId().equals(accountId))).findFirst();
    }
}
