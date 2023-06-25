package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prescriptions", schema = "MHEALTH")
@Getter
@Setter
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "therapist_id")
    private int therapistId;

    @Column(name = "session_time")
    private int sessionTime;

    @Column(name = "session_word_count")
    private int sessionWordCount;

    @Column(name = "session_word_set")
    private String sessionWordSet;

    @Column(name = "session_word_set_title")
    private String sessionWordSetTitle;

    @Column(name = "date_created")
    private Date dateCreated;
}
