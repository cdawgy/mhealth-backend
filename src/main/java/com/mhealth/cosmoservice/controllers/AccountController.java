package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
}
