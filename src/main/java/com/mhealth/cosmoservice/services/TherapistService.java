package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Therapist;
import main.java.com.mhealth.cosmoservice.repositories.TherapistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapistService {
    private TherapistRepository therapistRepository;

    public TherapistService(TherapistRepository therapistRepository) {
        this.therapistRepository = therapistRepository;
    }

    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }
}
