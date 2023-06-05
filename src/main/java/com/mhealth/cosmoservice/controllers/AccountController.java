package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Award;
import main.java.com.mhealth.cosmoservice.models.payloads.TherapistData;
import main.java.com.mhealth.cosmoservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{googleId}/active")
    boolean checkIfActiveAccount(@PathVariable String googleId) {
        // This end point will be used to check database for existing google ID
        // Return boolean based on search results.

        // Below ID is for personal email
        // This is to mimic a database query
        var returnedAccount = accountService.findAccount(googleId);
        return returnedAccount.isPresent();
    }

    @GetMapping("/{googleId}/type")
    String getAccountType(@PathVariable String googleId) {
        // Hard coding my personal email to be the parent account
        // Any other will act as a therapist for now.
        var returnedAccount = accountService.findAccount(googleId);
        return returnedAccount.get().getAccountType();
    }

//    @PostMapping("/awards")
//    ArrayList<Award> getAllAwardsRaw(@RequestBody TherapistData therapistData) {
//        // This will search the accounts db for a document that has the given google ID.
//        // If it finds one, it will return that accounts data, be it a therapist or parent.
//        var returnedAccount = (Parent)accountService.findAccountData(therapistData.getGoogleId());
//        return returnedAccount.getListOfAwards();
//    }

    @PostMapping("/awards")
    Map<Integer, Award[]> getList(@RequestBody TherapistData therapistData) {
        // This will search the accounts db for a document that has the given google ID.
        // If it finds one, it will return that accounts data, be it a therapist or parent.
        return accountService.getGroupedAwards(therapistData.getGoogleId());
    }
}
