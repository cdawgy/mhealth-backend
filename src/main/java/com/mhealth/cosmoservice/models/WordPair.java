package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WordPair {
    private String firstWord;
    private String secondWord;
}
