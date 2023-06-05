package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Account;
import main.java.com.mhealth.cosmoservice.models.AccountData;
import main.java.com.mhealth.cosmoservice.models.Award;
import main.java.com.mhealth.cosmoservice.models.Parent;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountService {
    public AccountService(){
    }

    public Optional<Account> findAccount(String accountId) {
        return InMemoryDatabase.AccountTable.stream().filter((account -> account.getAccountId().equals(accountId))).findFirst();
    }

    public AccountData findAccountData(String googleId) {
        return InMemoryDatabase.AccountDataTable.stream().filter(accountData -> accountData.getGoogleId().equalsIgnoreCase(googleId)).findFirst().orElseGet(null);
    }

    public Map<Integer, Award[]> getGroupedAwards(String googleId) {
        var parent = (Parent)findAccountData(googleId);
        return parent.getListOfAwards()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Award::getAwardCost,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        tl -> tl.toArray(new Award[0])
                                )
                        )
                );
    }
}
