package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
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
    public ArrayList<String> getAllTherapistsPatients(@RequestBody AccountId accountId) {
        var listOfAssocParents = accountService.getAllAssociatedParentsFor(accountId.getId());
        var listOfChildrenNames = new ArrayList<String>();
        listOfAssocParents.forEach(parent -> {
            int parentId = Math.toIntExact(parent.getId());
            var child = accountService.getChildForParentId(parentId);
            listOfChildrenNames.add(child.getFirstName());
        });
        return listOfChildrenNames;
    }

    @PostMapping("/patients/parents")
    public List<String> getAllPatientsParents(@RequestBody AccountId accountId) {
        var listOfParents = accountService.getAllAssociatedParentsFor(accountId.getId());
        return listOfParents.stream().map(Parent::getFirstName).collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<Therapist> getAllTherapists() {
        return therapistService.getAllTherapists();
    }
}
