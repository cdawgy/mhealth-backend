package main.java.com.mhealth.cosmoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Validator {
    @NonNull
    private boolean isConnected;
    @NonNull
    private boolean isSuccessful;
}
