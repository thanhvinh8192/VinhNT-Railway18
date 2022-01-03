package com.ntv.services;

import com.ntv.entities.Department;
import com.ntv.repositorys.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getListDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(int id){
        return departmentRepository.findById(id).get();
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> findDepartmentByName(Department.DepartmentNameEnum departmentName) {
        return departmentRepository.findDepartmentByName(departmentName);
    }

    @Override
    public Page<Department> getPagingDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}
