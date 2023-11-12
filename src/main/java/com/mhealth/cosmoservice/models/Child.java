package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Child {
    private Long id;

    private int parentId;

    private String firstName;

    private int points;

    public static Child getInstance(int parentId, String firstName){
        var newChild = new Child();
        newChild.setParentId(parentId);
        newChild.setFirstName(firstName);
        return newChild;
    }
}
