package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Prescription {
    private int id;

    private int parentId;

    private int therapistId;

    private int sessionTime;

    private int sessionWordCount;

    private String sessionWordSet;

    private String sessionWordSetTitle;

    private Date dateCreated;
}
