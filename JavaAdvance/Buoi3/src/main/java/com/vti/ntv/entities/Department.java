package com.vti.ntv.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter @Getter @ToString
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Column(name = "department_id") //column name in database
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private short departmentId;

    @Column(name = "department_name", length = 50, nullable = false)
    private String departmentName;
}
