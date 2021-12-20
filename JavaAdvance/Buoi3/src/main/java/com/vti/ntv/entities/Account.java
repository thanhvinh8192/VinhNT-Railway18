package com.vti.ntv.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "account")
public class Account {
    @Column(name = "account_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int accountID;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private Gender gender;
    private short departmentId;
    private short positionId;
    private Date createDate;

    public enum Gender{
        Male, Female, Unknown
    }
}
