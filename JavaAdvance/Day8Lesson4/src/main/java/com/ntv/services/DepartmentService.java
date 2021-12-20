package com.ntv.services;

import com.ntv.entity.Department;
import com.ntv.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(){
        departmentRepository = new DepartmentRepository();
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.getAllDepartments();
    }

    public void deleteDepartmentByIt(int id) {
        departmentRepository.deleteDepartmentById( id);
    }

    public void createDepartment(Department department){
        departmentRepository.createDepartment(department);
    }

    public void updateDepartment(Department department) {
        departmentRepository.updateDepartment(department);
    }
}
