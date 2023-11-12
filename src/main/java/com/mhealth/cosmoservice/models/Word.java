package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Word {
    private int id;

    private String word;

    private String phonemes;

    private String image_url;
}
