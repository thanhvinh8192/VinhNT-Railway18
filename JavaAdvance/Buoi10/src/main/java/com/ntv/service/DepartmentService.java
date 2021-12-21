package com.ntv.service;

import com.ntv.repository.IDepartmentRepository;
import org.json.JSONObject;

public class DepartmentService implements IDepartmentService{

    IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public JSONObject getDepartments() {
        return departmentRepository.getDepartments();
    }
}
