package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.payloads.TherapistData;
import main.java.com.mhealth.cosmoservice.services.TherapistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/therapist")
public class TherapistController {
    private TherapistService therapistService;

    public TherapistController(TherapistService therapistServices) {
        this.therapistService = therapistServices;
    }

    @PostMapping("/patients")
    public List<String> getAllTherapistsPatients(@RequestBody TherapistData therapistData) {
        Logger.getAnonymousLogger().info(therapistData.toString());
        return therapistService.getAllTherapistsPatients(therapistData.getGoogleId());
    }

    @PostMapping("/patients/parents")
    public List<String> getAllPatientsParents(@RequestBody TherapistData therapistData) {
        return therapistService.getAllTherapistsPatientsParents(therapistData.getGoogleId());
    }
}
