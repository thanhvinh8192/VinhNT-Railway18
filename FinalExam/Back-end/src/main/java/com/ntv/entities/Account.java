package com.ntv.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    @NonNull
    private String username;

    @Column(name = "`password`", nullable = false, length = 800)
    @NonNull
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    @NonNull
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    @NonNull
    private String lastName;


    @Enumerated(EnumType.STRING)
    @Column(name = "`role`", nullable = false, columnDefinition = "ENUM('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @NonNull
    private AccountRoleEnum role;

    @ManyToOne()
    @JoinColumn(name = "department_id", nullable = false)
    @NonNull
    private Department department;

    public enum AccountRoleEnum{
        ADMIN, EMPLOYEE, MANAGER;

        public static AccountRoleEnum toEnum(String role) {
            for (AccountRoleEnum item : AccountRoleEnum.values()) {
                if (item.toString().equals(role)){
                    return item;
                }
            }
            return null;
        }

    }
}