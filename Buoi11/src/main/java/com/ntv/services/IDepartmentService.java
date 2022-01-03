package com.ntv.services;

import com.ntv.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {

    List<Department> getListDepartments();

    Department findDepartmentById(int id);

    void createDepartment(Department department);

    List<Department> findDepartmentByName(Department.DepartmentNameEnum departmentName);

    Page<Department> getPagingDepartments(Pageable pageable);
}
