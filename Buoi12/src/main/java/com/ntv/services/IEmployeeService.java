package com.ntv.services;

import com.ntv.dto.EmployeeDTO;
import com.ntv.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getListEmployees();

    Employee getEmployeeById(int id);
}
