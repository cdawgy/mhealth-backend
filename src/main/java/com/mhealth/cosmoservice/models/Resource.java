package main.java.com.mhealth.cosmoservice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Resource {
    private int id;

    private String title;

    private String content;
}
