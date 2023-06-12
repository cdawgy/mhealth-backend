package main.java.com.mhealth.cosmoservice.models.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.mhealth.cosmoservice.models.Award;

@Data
@NoArgsConstructor
public class AwardRequest {
    private String googleId;
    private Award award;
}
