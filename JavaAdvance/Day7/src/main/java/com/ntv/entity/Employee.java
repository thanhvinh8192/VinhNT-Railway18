package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`employee`")
public class Employee {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name", length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "employee_department",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private List<Department> departments;

    @Override
    public String toString() {
        return "Employee{" +
                "id= " + id +
                ", name= '" + name +
                '}';
    }
}
