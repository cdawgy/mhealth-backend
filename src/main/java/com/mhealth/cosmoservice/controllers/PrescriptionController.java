package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Prescription;
import main.java.com.mhealth.cosmoservice.models.Word;
import main.java.com.mhealth.cosmoservice.models.payloads.PrescriptionRequest;
import main.java.com.mhealth.cosmoservice.services.PrescriptionService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
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

    @GetMapping("/words/processes")
    public List<String> getAllPhonologicalProcesses() {
        return prescriptionService.getAllPhonologicalProcesses();
    }

    @GetMapping("/words/processes/{processName}")
    public List<String> getPhonologicalPresets(@PathVariable String processName) {
        return prescriptionService.getPhonologicalProcessPresets(processName);
    }

    @GetMapping("/words/processes/{processName}/{presetName}")
    public List<Pair<Word, Word>> getPhonologicalPreset(@PathVariable String processName, @PathVariable String presetName) {
        return prescriptionService.getPhonologicalProcessPresetBasedOff(processName, presetName);
    }

    @GetMapping("/words/group/{group}")
    public List<Word> getFilteredWordsFromGroup(@PathVariable String group) {
        return group.equalsIgnoreCase("all") ? prescriptionService.getAllWords() : prescriptionService.getFilteredWordsFromGroup(group);
    }

    @PostMapping("/prescribe")
    public Prescription prescribeSessionToParent(@RequestBody PrescriptionRequest prescriptionRequest) {
        return prescriptionService.savePrescription(prescriptionRequest);
    }

    @GetMapping("/prescriptions/{parentId}")
    public List<Prescription> getPrescriptionsForChild(@PathVariable int parentId) {
        return prescriptionService.getPrescriptionsForChild(parentId);
    }
}
