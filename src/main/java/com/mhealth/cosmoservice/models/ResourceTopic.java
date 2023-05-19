package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResourceTopic {
    private String topicName;
    private String topicContent;
}
