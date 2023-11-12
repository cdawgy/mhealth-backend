package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Therapist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistService {

    public TherapistService() {

    }

    public List<Therapist> getAllTherapists() {
        return InMemoryDatabase.TherapistTable;
    }
}
