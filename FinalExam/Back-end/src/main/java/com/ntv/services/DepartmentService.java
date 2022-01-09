package com.ntv.services;

import com.ntv.entities.Department;
import com.ntv.repositories.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getListDepartments() {
        return departmentRepository.findAll();
    }
}
