package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.services.TherapistService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/therapist")
public class TherapistController {
    private TherapistService therapistService;

    public TherapistController(TherapistService therapistServices) {
        this.therapistService = therapistServices;
    }

    @GetMapping("/patients")
    public ArrayList<String> getAllTherapistsPatients() {
        return therapistService.getAllTherapistsPatients();
    }
}
