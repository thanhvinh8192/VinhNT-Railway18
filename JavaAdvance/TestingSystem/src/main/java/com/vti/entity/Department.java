package com.vti.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter @Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Column(name = "department_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "department_name", length = 50, nullable = false)
    private String departmentName;
}