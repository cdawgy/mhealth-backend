package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Child {
    private String firstname;
    private String surname;
    private String parent;

    public String getFullName() {
        return this.firstname + " " + this.surname;
    }
}
