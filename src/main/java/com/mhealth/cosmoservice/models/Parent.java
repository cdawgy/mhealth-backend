package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Parent extends AccountData{
    public Parent(String googleId, String firstname, String surname){
        super(googleId, firstname, surname);
    }
    private ArrayList<Award> listOfAwards;
    private Child child;
}
