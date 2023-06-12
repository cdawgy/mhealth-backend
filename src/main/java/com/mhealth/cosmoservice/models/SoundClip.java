package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sounds", schema = "MHEALTH")
@Getter
@Setter
public class SoundClip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "child_id")
    private int childId;

    @Column(name = "sound")
    private String sound;

    @Column(name = "word")
    private String word;

    @Column(name = "location_url")
    private String locationUrl;

    @Column(name = "date_created")
    private Date dateCreated;
}
