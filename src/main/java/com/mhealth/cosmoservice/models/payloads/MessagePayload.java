package main.java.com.mhealth.cosmoservice.models.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessagePayload {
    private int selectedParent;
    private int selectedResource;
    private String messageBody;
}
