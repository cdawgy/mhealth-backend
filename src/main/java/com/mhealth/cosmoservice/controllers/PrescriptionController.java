package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Word;
import main.java.com.mhealth.cosmoservice.services.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/prescription")
public class PrescriptionController {
    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/words/all")
    public List<Word> getAllWordPairs() {
        return prescriptionService.getAllWords();
    }

    @GetMapping("/words/groups")
    public List<String> getAllPhonologicalGroupings() {
        return prescriptionService.getAllPhonologicalGroupings();
    }

    @GetMapping("/words/group/{group}")
    public List<Word> getFilteredWordsFromGroup(@PathVariable String group) {
        return prescriptionService.getFilteredWordsFromGroup(group);
    }
}
