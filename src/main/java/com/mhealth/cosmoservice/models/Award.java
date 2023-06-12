package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "awards", schema = "MHEALTH")
@Getter
@Setter
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;
}
