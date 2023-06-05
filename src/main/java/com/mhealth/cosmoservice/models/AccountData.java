package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class AccountData {
    private String googleId;
    private String firstname;
    private String surname;

    AccountData(String googleId, String firstname, String surname) {
        this.googleId = googleId;
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFullName() {
        return this.firstname + " " + this.surname;
    }
}
