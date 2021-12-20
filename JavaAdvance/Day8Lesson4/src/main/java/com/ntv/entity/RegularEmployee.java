package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Regular Employee")
public class RegularEmployee extends Employee {

    @Column(name = "salary")
    private int salary;

    @Column(name = "bonus")
    private int bonus;

    public RegularEmployee(String employeeName, int salary, int bonus) {
        super(employeeName);
        this.salary = salary;
        this.bonus = bonus;
    }
}
