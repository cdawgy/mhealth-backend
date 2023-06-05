package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Award {
    private int awardCost;
    private String awardTitle;
}
