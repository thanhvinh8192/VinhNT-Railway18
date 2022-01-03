package com.ntv.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter @Setter @NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;

    @Column(name = "employee_name", length = 50, nullable = false)
    @NonNull
    private String employeeName;


    @ManyToOne
    @JoinColumn(name = "department_id")
    @NonNull
    private  Department department;

}
