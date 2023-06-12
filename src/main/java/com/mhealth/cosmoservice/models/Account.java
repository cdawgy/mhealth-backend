package main.java.com.mhealth.cosmoservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accounts", schema = "MHEALTH")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "google_id")
    private String googleId;
    @Column(name = "account_type")
    private String accountType;
}
