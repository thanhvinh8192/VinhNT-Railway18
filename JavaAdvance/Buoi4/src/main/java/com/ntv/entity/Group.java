package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @ToString @NoArgsConstructor
@Entity
@Table(name = "`groups`")
public class Group {

    public Group(String groupName, LocalDate createdDate) {
        this.groupName = groupName;
        this.createdDate = createdDate;
    }

    @Column(name = "group_id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short groupId;

    @Column(name = "group_name", nullable = false, unique = true, length = 50)
    private String groupName;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;
}
