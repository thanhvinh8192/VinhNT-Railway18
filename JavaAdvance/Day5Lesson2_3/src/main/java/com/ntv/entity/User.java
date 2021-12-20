package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter @Setter @ToString @NoArgsConstructor
@Entity @Table(name = "`user`")
public class User {

    public User(String username, int age){
        this.username = username;
        this.age = age;
    }

    @Column(name = "user_id", length = 50, nullable = false) @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID userId;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "age")
    private int age;
}
