package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "`employee`")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "`type`", discriminatorType = DiscriminatorType.STRING)
public class Employee {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name",length = 50, nullable = false)
    private String employeeName;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }
}
