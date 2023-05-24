package main.java.com.mhealth.cosmoservice.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TherapistService {
    private ArrayList<String> listOfPatients;

    public TherapistService(){
        listOfPatients = new ArrayList<>();
        listOfPatients.add("James Carson");
        listOfPatients.add("Sam Foley");
        listOfPatients.add("Dylan McDonnell");
    }

    public ArrayList<String> getAllTherapistsPatients() {
        return listOfPatients;
    }
}
