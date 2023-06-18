package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Word;
import main.java.com.mhealth.cosmoservice.models.WordPair;
import main.java.com.mhealth.cosmoservice.repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    private WordRepository wordRepository;

    public PrescriptionService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public List<String> getAllPhonologicalGroupings() {
//        return List.of("All", "Cluster Reduction", "Stopping of Affricates", "Stopping of Fricatives", "Velar Fronting");
        return List.of("All", "k", "t", "g", "d", "f", "b", "s");
    }

    public List<Word> getFilteredWordsFromGroup(String phonologicalGroup) {
        var allWords = wordRepository.findAll();
        return allWords.stream().filter(word -> word.getPhonemes().contains(phonologicalGroup)).collect(Collectors.toList());
    }
}
