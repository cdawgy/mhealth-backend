package main.java.com.mhealth.cosmoservice.models;

import lombok.*;

@Getter
@Setter
public class Parent {
    private Long id;

    private String googleId;

    private String firstName;

    private String surname;

    private int childId;

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
