package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter @NoArgsConstructor
@Entity
@DiscriminatorValue("Contract Employee")
public class ContractEmployee extends Employee {

    @Column(name = "pay_per_hour")
    private int payPerHour;

    @Column(name = "contract_duration")
    private String contractDuration;

    public ContractEmployee(String employeeName, int payPerHour, String contractDuration) {
        super(employeeName);
        this.payPerHour = payPerHour;
        this.contractDuration = contractDuration;
    }
}
