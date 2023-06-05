package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Therapist extends AccountData {
    public Therapist(String googleId, String firstname, String surname) {
        super(googleId, firstname, surname);
    }

    private ArrayList<String> listOfPatientsIds;
}
