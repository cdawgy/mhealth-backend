package main.java.com.mhealth.cosmoservice.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parents", schema = "MHEALTH")
@Getter
@Setter
public class Parent {
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

    @Column(name = "child_id")
    private int childId;

    @Column(name = "therapist_id")
    private int therapistId;

    public static Parent getInstance(String googleId, String firstName, String surname, int therapistId, int childId) {
        var newParent = new Parent();
        newParent.setFirstName(firstName);
        newParent.setGoogleId(googleId);
        newParent.setSurname(surname);
        newParent.setTherapistId(therapistId);
        newParent.setChildId(childId);
        return newParent;
    }
}
