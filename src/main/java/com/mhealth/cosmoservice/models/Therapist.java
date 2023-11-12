package main.java.com.mhealth.cosmoservice.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Therapist {
    private int id;

    private String googleId;

    private String firstName;

    private String surname;
}
