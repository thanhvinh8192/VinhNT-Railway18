package com.vti.service;

import java.util.List;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;

public interface IDepartmentService {

	public List<Department> getAllDepartments();

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(DepartmentFormForCreating form);

	public void updateDepartment(Department department);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);
}
