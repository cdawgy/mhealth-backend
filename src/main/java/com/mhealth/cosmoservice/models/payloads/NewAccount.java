package main.java.com.mhealth.cosmoservice.models.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewAccount {
    private String accountType;
    private String childsName;
    private int selectedTherapist;
    private String firstName;
    private String surname;
    private String googleId;
}
