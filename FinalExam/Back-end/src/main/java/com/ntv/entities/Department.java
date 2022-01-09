package com.ntv.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "department_name", nullable = false, length = 50, unique = true)
    @NonNull
    private String departmentName;

    @Column(name = "total_member", nullable = false)
    @NonNull
    private int totalMember;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "ENUM('Dev','Test','ScrumMaster','PM')")
    @NonNull
    private DepartmentTypeEnum type;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @NonNull
    private Date createdDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public enum DepartmentTypeEnum{
        Dev, Test , ScrumMaster, PM;

        public static DepartmentTypeEnum toEnum(String role) {
            for (DepartmentTypeEnum item : DepartmentTypeEnum.values()) {
                if (item.toString().equals(role)){
                    return item;
                }
            }
            return null;
        }
    }

}