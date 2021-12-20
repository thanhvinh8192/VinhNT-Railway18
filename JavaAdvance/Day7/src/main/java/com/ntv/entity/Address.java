package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`address`")
public class Address {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
