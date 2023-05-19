package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class SoundClip {
    private int id;
    private String word;
    private String sound;
    private Date date;
}
