package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountService {

//    private final AccountRepository accountRepository;
//    private final ParentRepository parentRepository;
//    private final TherapistRepository therapistRepository;
//    private final ChildRepository childRepository;

    @Autowired
    public AccountService() {
//        this.accountRepository = accountRepository;
//        this.parentRepository = parentRepository;
//        this.therapistRepository = therapistRepository;
//        this.childRepository = childRepository;
    }

    public Optional<Account> findAccount(String googleId) {
//        return this.accountRepository.findByGoogleIdIs(googleId).stream().findFirst();
        return InMemoryDatabase.AccountTable.stream().filter(account -> account.getGoogleId().equalsIgnoreCase(InMemoryDatabase.PARENT_ACCOUNT_GOOGLE_ID)).findFirst();
    }

    public Parent findParentAccount(String googleId) {
        var foundAccount = InMemoryDatabase.ParentTable.stream().filter(parent -> parent.getGoogleId().equalsIgnoreCase(InMemoryDatabase.PARENT_ACCOUNT_GOOGLE_ID)).findFirst();
//        var foundAccount = parentRepository.findByGoogleIdIs(googleId).stream().findFirst();
        return foundAccount.orElse(null);
    }

    public Therapist findTherapistAccount(String googleId) {
        var foundAccount = InMemoryDatabase.TherapistTable.stream().filter(parent -> parent.getGoogleId().equalsIgnoreCase(InMemoryDatabase.PARENT_ACCOUNT_GOOGLE_ID)).findFirst();
//        var foundAccount = therapistRepository.findByGoogleIdIs(googleId).stream().findFirst();
        return foundAccount.orElse(null);
    }

    public List<Parent> getAllAssociatedParentsFor(int therapistId) {
//        return parentRepository.findAllParentsForTherapistOfId(therapistId);
        return InMemoryDatabase.ParentTable.stream().filter(parent -> parent.getTherapistId() == therapistId).collect(Collectors.toList());
    }

    public Child getChildForParentId(int parentId) {
//        return childRepository.findByParentIdIs(parentId).stream().findFirst().orElse(null);
        return InMemoryDatabase.ChildTable.stream().filter(child -> child.getParentId() == parentId).findFirst().orElse(null);
    }

    public Child createChildRecord(String childsName) {
        return Child.getInstance(0, childsName);
//        return childRepository.save(newChild);
    }

    public void updateChildRecordWithParentId(Long childId, int parentId) {
//        var child = childRepository.findById(childId).get();
//        child.setParentId(parentId);
//        childRepository.save(child);
    }

    public Parent createParentRecord(String googleId, String firstName, String surname, int therapistId, int childId) {
        return Parent.getInstance(googleId, firstName, surname, therapistId, childId);
//        return parentRepository.save(newParent);
    }

    public Account createNewAccount(String googleId, String accountType) {
//        var account = new Account();
//        account.setGoogleId(googleId);
//        account.setAccountType(accountType);
        return Account.builder().build();
    }
}
