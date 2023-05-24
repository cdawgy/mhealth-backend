package main.java.com.mhealth.cosmoservice.controllers;

import com.azure.core.annotation.Get;
import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.services.TherapistService;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @Get("/patients")
    public ArrayList<String> getAllTherapistsPatients() {
        return therapistService.getAllTherapistsPatients();
    }
}
