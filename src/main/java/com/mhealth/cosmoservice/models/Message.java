package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Message {
    private int id;

    private int parentId;

    private int resourceId;

    private String messageBody;

    private String readState;
}
