package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {
    private int id;
    private String googleId;
    private String accountType;
}
