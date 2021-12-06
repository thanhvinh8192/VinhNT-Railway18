package com.vti;


import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.PositionRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("Demo Hibernate Java Advance");

        /*
        DepartmentRepository departmentRepository = new DepartmentRepository();
        List<Department> listDepartments = departmentRepository.getAllDepartments();

        System.out.println("Danh sach phong ban:");
        for (Department department : listDepartments) {
            System.out.println(department.getDepartmentName());
        }
        System.out.println(departmentRepository.getDepartmentById(2).getDepartmentName());
        System.out.println(departmentRepository.getDepartmentByName("Phong Ky Thuat 2"));

        //Insert to database
        Department department = new Department();
        department.setDepartmentName("Phong Scrum Master");
        departmentRepository.createDepartment(department);
        //departmentRepository.updateDepartment(2, "Security");
        departmentRepository.deleteDepartmentById2(8);
        System.out.println(departmentRepository.isDepartmentExistsById(8));

        System.out.println(departmentRepository.getAllDepartments());
        */

        PositionRepository positionRepository = new PositionRepository();
        System.out.println(positionRepository.getAllPosition());
    }
}
