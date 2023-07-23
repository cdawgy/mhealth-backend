package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Prescription;
import main.java.com.mhealth.cosmoservice.models.Word;
import main.java.com.mhealth.cosmoservice.models.WordPair;
import main.java.com.mhealth.cosmoservice.models.payloads.PrescriptionRequest;
import main.java.com.mhealth.cosmoservice.repositories.PrescriptionRepository;
import main.java.com.mhealth.cosmoservice.repositories.WordRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    private WordRepository wordRepository;
    private PrescriptionRepository prescriptionRepository;
    private Map<String, Map<String, List<Pair<Integer, Integer>>>> presets;

    public PrescriptionService(WordRepository wordRepository, PrescriptionRepository prescriptionRepository) {
        this.wordRepository = wordRepository;
        this.prescriptionRepository = prescriptionRepository;

        this.presets = new HashMap<>();
        var stoppingOfFricativesMap = new HashMap<String, List<Pair<Integer, Integer>>>();
        stoppingOfFricativesMap.put("f vs b", List.of(
                Pair.of(27, 28),
                Pair.of(29, 30),
                Pair.of(31, 32),
                Pair.of(33, 34),
                Pair.of(35, 36),
                Pair.of(37, 38),
                Pair.of(39, 40)
        ));

//        stoppingOfFricativesMap.put("f vs p", List.of(
//                Pair.of(29, 28),
//                Pair.of(29, 30),
//                Pair.of(31, 32),
//                Pair.of(33, 34),
//                Pair.of(35, 36),
//                Pair.of(37, 38),
//                Pair.of(39, 40)
//        ));

        presets.put("Stopping of Fricatives", stoppingOfFricativesMap);
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public List<String> getAllPhonologicalGroupings() {
        return List.of("All", "k", "t", "g", "d", "f", "b", "s");
    }

    public List<String> getAllPhonologicalProcesses() {
//        return List.of("All", "Cluster Reduction", "Stopping of Affricates", "Stopping of Fricatives", "Velar Fronting");
        return new ArrayList<>(presets.keySet());
    }

    public List<String> getPhonologicalProcessPresets(String processName) {
        var processPresets = presets.get(processName);
        return new ArrayList<>(processPresets.keySet());
    }

    public List<Pair<Word, Word>> getPhonologicalProcessPresetBasedOff(String processName, String presetName) {
        var processPresets = presets.get(processName);
        return processPresets.get(presetName).stream().map(this::getWordPairFromIds).collect(Collectors.toList());
    }

    private Pair<Word, Word> getWordPairFromIds(Pair<Integer, Integer> wordIdPair) {
        var firstWordId = wordIdPair.getFirst();
        var firstWord = wordRepository.findById(firstWordId.longValue()).get();
        var secondWordId = wordIdPair.getSecond();
        var secondWord = wordRepository.findById(secondWordId.longValue()).get();
        return Pair.of(firstWord, secondWord);
    }

    public List<Word> getFilteredWordsFromGroup(String phonologicalGroup) {
        var allWords = wordRepository.findAll();
        return allWords.stream().filter(word -> word.getPhonemes().contains(phonologicalGroup)).collect(Collectors.toList());
    }

    public Prescription savePrescription(PrescriptionRequest prescriptionRequest) {
        var prescription = new Prescription();
        prescription.setParentId(1);
        prescription.setTherapistId(prescriptionRequest.getTherapistId());
        prescription.setSessionTime(prescriptionRequest.getSessionTime());
        prescription.setSessionWordCount(prescriptionRequest.getSessionWordCount());
        prescription.setSessionWordSet(prescriptionRequest.getSessionWordSet());
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getPrescriptionsForChild(int parentId) {
        return prescriptionRepository.findByParentIdIs(parentId);
    }
}
