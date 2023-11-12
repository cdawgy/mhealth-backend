package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Account;
import main.java.com.mhealth.cosmoservice.models.Award;
import main.java.com.mhealth.cosmoservice.models.payloads.AccountId;
import main.java.com.mhealth.cosmoservice.models.payloads.NewAccount;
import main.java.com.mhealth.cosmoservice.services.AccountService;
import main.java.com.mhealth.cosmoservice.services.AwardsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AwardsService awardsService;

    public AccountController(AccountService accountService, AwardsService awardsService) {
        this.accountService = accountService;
        this.awardsService = awardsService;
    }

    @PostMapping("/create")
    Account createNewAccount(@RequestBody NewAccount newAccount) {
        if (newAccount.getAccountType().equalsIgnoreCase("parent")) {
            var newChild = accountService.createChildRecord(newAccount.getChildsName());
            var newParent = accountService.createParentRecord(
                    newAccount.getGoogleId(),
                    newAccount.getFirstName(),
                    newAccount.getSurname(),
                    newAccount.getSelectedTherapist(),
                    Math.toIntExact(newChild.getId())
            );
            accountService.updateChildRecordWithParentId(newChild.getId(), Math.toIntExact(newParent.getId()));
            return accountService.createNewAccount(newAccount.getGoogleId(), newAccount.getAccountType());
        } else {
            return accountService.createNewAccount(newAccount.getGoogleId(), newAccount.getAccountType());
        }
    }

    @GetMapping("/{googleId}/active")
    boolean checkIfActiveAccount(@PathVariable String googleId) {
        var returnedAccount = accountService.findAccount(googleId);
        return returnedAccount.isPresent();
    }

    @GetMapping("/{googleId}/type")
    String getAccountType(@PathVariable String googleId) {
        var returnedAccount = accountService.findAccount(googleId);
        return returnedAccount.isPresent() ? returnedAccount.get().getAccountType() : null;
    }

    @GetMapping("/{accountType}/{googleId}")
    Long getAccountTableReferenceId(@PathVariable String accountType, @PathVariable String googleId) {
        if (accountType.equalsIgnoreCase("parent")) {
            return accountService.findParentAccount(googleId).getId();
        } else if (accountType.equalsIgnoreCase("therapist")) {
            // TODO: Update this to therapist
            return Long.valueOf(accountService.findTherapistAccount(googleId).getId());
        }
        return null;
    }

    @PostMapping("/awards")
    HashMap<Integer, List<Award>> getAllAccountAwards(@RequestBody AccountId accountId) {
        var listOfAwards = awardsService.getAllAwardsForId(accountId.getId());
        var groupedAwards = new HashMap<Integer, List<Award>>();
        listOfAwards.forEach(award -> {
            if (!groupedAwards.containsKey(award.getCost())) {
                var listGroupedByAwardCost = new ArrayList<Award>();
                listGroupedByAwardCost.add(award);

                groupedAwards.put(award.getCost(), listGroupedByAwardCost);
            } else {
                groupedAwards.get(award.getCost()).add(award);
            }
        });
        return groupedAwards;
    }

    @PostMapping("/awards/create")
    void createNewAward(@RequestBody Award award) {
//        var newAward = new Award();
//        newAward.setCost(award.getCost());
//        newAward.setParentId(award.getParentId());
//        newAward.setTitle(award.getTitle());
//        awardsService.createNewAward(newAward);
    }
}
