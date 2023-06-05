package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Child;
import main.java.com.mhealth.cosmoservice.models.Parent;
import main.java.com.mhealth.cosmoservice.models.Therapist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TherapistService {
    public TherapistService(){
    }

    public List<String> getAllTherapistsPatients(String therapistAccountId) {
        Logger.getAnonymousLogger().info("Test Log");
        Logger.getAnonymousLogger().info(therapistAccountId);
        var therapistAccountData = (Therapist)InMemoryDatabase.AccountDataTable.stream().filter(accountData -> accountData.getGoogleId().equalsIgnoreCase(therapistAccountId)).findFirst().orElseGet(null);
        return therapistAccountData
                .getListOfPatientsIds()
                .stream()
                .map(patientId -> {
                    var patientAccountData = (Parent)InMemoryDatabase.AccountDataTable.stream().filter(accountData -> accountData.getGoogleId().equalsIgnoreCase(patientId)).findFirst().get();
                    return patientAccountData.getChild().getFullName();
                })
                .collect(Collectors.toList());
    }

    public List<String> getAllTherapistsPatientsParents(String therapistAccountId) {
        var therapistAccountData = (Therapist)InMemoryDatabase.AccountDataTable.stream().filter(accountData -> accountData.getGoogleId().equalsIgnoreCase(therapistAccountId)).findFirst().orElseGet(null);
        return therapistAccountData
                .getListOfPatientsIds()
                .stream()
                .map(patientId -> {
                    var patientAccountData = (Parent)InMemoryDatabase.AccountDataTable.stream().filter(accountData -> accountData.getGoogleId().equalsIgnoreCase(patientId)).findFirst().get();
                    return patientAccountData.getFullName();
                })
                .collect(Collectors.toList());
    }
}
