package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "children", schema = "MHEALTH")
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "points")
    private int points;

    public static Child getInstance(int parentId, String firstName){
        var newChild = new Child();
        newChild.setParentId(parentId);
        newChild.setFirstName(firstName);
        return newChild;
    }
}
