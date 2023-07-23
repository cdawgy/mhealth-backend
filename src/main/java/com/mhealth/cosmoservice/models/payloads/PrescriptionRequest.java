package main.java.com.mhealth.cosmoservice.models.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrescriptionRequest {
    private int parentId;
    private int therapistId;
    private int sessionTime;
    private int sessionWordCount;
    private String sessionWordSet;
}
