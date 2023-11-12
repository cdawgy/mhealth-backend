package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class SoundClip {
    private int id;

    private int childId;

    private String sound;

    private String word;

    private String locationUrl;

    private Date dateCreated;
}
