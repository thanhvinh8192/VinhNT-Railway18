package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter @ToString @NoArgsConstructor
@Entity
@Table(name = "department")
public class Department implements Serializable {

    public Department( DepartmentNameEnum departmentName, LocalDate createdAt){
        this.departmentName= departmentName;
        this.createdAt = createdAt;
    }

    @Column(name = "id")
    @Id
    @GenericGenerator(name = "sequence_dep_id", strategy = "com.ntv.entity.DepartmentCodeGenerator")
    @GeneratedValue(generator = "sequence_dep_id")
    private String id;


    @Column(name = "created_at")
    private LocalDate createdAt;

    /*@Column(name = "name", columnDefinition = "ENUM('DEV', 'SALE', 'TECHNICAL', 'HUMAN_RESOURCES', 'DEV_OPTS')")
    @Enumerated(EnumType.STRING)*/
    @Column(name = "name", columnDefinition = "ENUM('D', 'S', 'T', 'HR', 'DO')")
    @Convert(converter = DepartmentNameConverter.class)
    private DepartmentNameEnum departmentName;

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
