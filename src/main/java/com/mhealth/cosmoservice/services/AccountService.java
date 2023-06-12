package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.*;
import main.java.com.mhealth.cosmoservice.repositories.AccountRepository;
import main.java.com.mhealth.cosmoservice.repositories.ChildRepository;
import main.java.com.mhealth.cosmoservice.repositories.ParentRepository;
import main.java.com.mhealth.cosmoservice.repositories.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ParentRepository parentRepository;
    private final TherapistRepository therapistRepository;
    private final ChildRepository childRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, ParentRepository parentRepository, TherapistRepository therapistRepository, ChildRepository childRepository) {
        this.accountRepository = accountRepository;
        this.parentRepository = parentRepository;
        this.therapistRepository = therapistRepository;
        this.childRepository = childRepository;
    }

    public Optional<Account> findAccount(String googleId) {
        return this.accountRepository.findByGoogleIdIs(googleId).stream().findFirst();
    }

    public Parent findParentAccount(String googleId) {
        var foundAccount = parentRepository.findByGoogleIdIs(googleId).stream().findFirst();
        return foundAccount.orElse(null);
    }

    public Therapist findTherapistAccount(String googleId) {
        var foundAccount = therapistRepository.findByGoogleIdIs(googleId).stream().findFirst();
        return foundAccount.orElse(null);
    }

    public List<Parent> getAllAssociatedParentsFor(int therapistId) {
        return parentRepository.findAllParentsForTherapistOfId(therapistId);
    }

    public Child getChildForParentId(int parentId) {
        return childRepository.findByParentIdIs(parentId).stream().findFirst().orElse(null);
    }

    public Child createChildRecord(String childsName) {
        var newChild = Child.getInstance(0, childsName);
        return childRepository.save(newChild);
    }

    public void updateChildRecordWithParentId(Long childId, int parentId) {
        var child = childRepository.findById(childId).get();
        child.setParentId(parentId);
        childRepository.save(child);
    }

    public Parent createParentRecord(String googleId, String firstName, String surname, int therapistId, int childId) {
        var newParent = Parent.getInstance(googleId, firstName, surname, therapistId, childId);
        return parentRepository.save(newParent);
    }

    public Account createNewAccount(String googleId, String accountType) {
        var account = new Account();
        account.setGoogleId(googleId);
        account.setAccountType(accountType);
        return accountRepository.save(account);
    }
}
