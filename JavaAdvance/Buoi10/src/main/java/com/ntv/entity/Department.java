package com.ntv.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "created_at")
    private LocalDate createdAt;

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


        public static DepartmentNameEnum toEnum2(String name){
            for (DepartmentNameEnum item: DepartmentNameEnum.values()) {
                if(item.toString().equals(name))
                    return item;
            }
            return null;
        }
    }
}
