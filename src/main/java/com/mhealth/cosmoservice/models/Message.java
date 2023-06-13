package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "messages", schema = "MHEALTH")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "resource_id")
    private int resourceId;

    @Column(name = "message_body")
    private String messageBody;

    @Column(name = "read_state")
    private String readState;
}
