package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Account {
    private String accountId;
    private String accountType;
}
