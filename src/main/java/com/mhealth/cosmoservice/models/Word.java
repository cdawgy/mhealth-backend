package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "words", schema = "MHEALTH")
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "phonemes")
    private String phonemes;

    @Column(name = "image_url")
    private String image_url;
}
