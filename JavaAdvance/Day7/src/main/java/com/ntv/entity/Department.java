package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    public Department( DepartmentNameEnum departmentName, LocalDate createdAt){
        this.departmentName= departmentName;
        this.createdAt = createdAt;
    }

    @Column(name = "id")
    @Id
    private String id;


    @Column(name = "created_at")
    private LocalDate createdAt;

    /*@Column(name = "name", columnDefinition = "ENUM('DEV', 'SALE', 'TECHNICAL', 'HUMAN_RESOURCES', 'DEV_OPTS')")
    @Enumerated(EnumType.STRING)*/
    @Column(name = "name", columnDefinition = "ENUM('D', 'S', 'T', 'HR', 'DO')")
    @Convert(converter = DepartmentNameConverter.class)
    private DepartmentNameEnum departmentName;

    @ManyToMany(mappedBy = "departments")
    private List<Employee> employees;



    public enum DepartmentNameEnum {
        DEV("D"), SALE("S"), TECHNICAL("T"), HUMAN_RESOURCES("HR"), DEV_OPTS("DO");

        private String name;
        public String getName(){
            return name;
        }
        DepartmentNameEnum(String name){
            this.name = name;
        }

        public static DepartmentNameEnum toEnum(String name){
            for (DepartmentNameEnum item: DepartmentNameEnum.values()) {
                if(item.getName().equals(name)) return item;
            }
            return null;
        }
    }
}
