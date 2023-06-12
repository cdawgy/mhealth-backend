package main.java.com.mhealth.cosmoservice.models;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "therapists", schema = "MHEALTH")
@Getter
@Setter
public class Therapist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;
}
