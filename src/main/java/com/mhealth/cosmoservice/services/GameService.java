package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.WordPair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    private ArrayList<WordPair> listOfWordPairs;

    public GameService(){
        listOfWordPairs = new ArrayList<>();
        listOfWordPairs.add(WordPair.builder().firstWord("Tea").secondWord("Pea").build());
        listOfWordPairs.add(WordPair.builder().firstWord("Soap").secondWord("Pope").build());
    }

    public ArrayList<WordPair> getAllWordPairs() {
        return listOfWordPairs;
    }
}
