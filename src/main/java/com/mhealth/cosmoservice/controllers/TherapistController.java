package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Child;
import main.java.com.mhealth.cosmoservice.models.Parent;
import main.java.com.mhealth.cosmoservice.models.Therapist;
import main.java.com.mhealth.cosmoservice.models.payloads.AccountId;
import main.java.com.mhealth.cosmoservice.models.payloads.TherapistData;
import main.java.com.mhealth.cosmoservice.services.AccountService;
import main.java.com.mhealth.cosmoservice.services.TherapistService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/therapist")
public class TherapistController {
    private TherapistService therapistService;
    private AccountService accountService;

    public TherapistController(TherapistService therapistServices, AccountService accountService) {
        this.therapistService = therapistServices;
        this.accountService = accountService;
    }

    @PostMapping("/patients")
    public ArrayList<Child> getAllTherapistsPatients(@RequestBody AccountId accountId) {
        var listOfAssocParents = accountService.getAllAssociatedParentsFor(accountId.getId());
        var listOfChildPatients = new ArrayList<Child>();
        listOfAssocParents.forEach(parent -> {
            int parentId = Math.toIntExact(parent.getId());
            var child = accountService.getChildForParentId(parentId);
            listOfChildPatients.add(child);
        });
        return listOfChildPatients;
    }

    @PostMapping("/patients/parents")
    public List<Parent> getAllPatientsParents(@RequestBody AccountId accountId) {
        return accountService.getAllAssociatedParentsFor(accountId.getId());
    }

    @GetMapping("/all")
    public List<Therapist> getAllTherapists() {
        return therapistService.getAllTherapists();
    }
}
