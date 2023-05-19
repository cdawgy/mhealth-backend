package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class Resource {
    private int id;
    private String title;
    private ArrayList<ResourceTopic> topicList;
}
