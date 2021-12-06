package com.vti.ntv.controller;

import com.vti.ntv.entities.Department;
import com.vti.ntv.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value ="api")
public class DepartmentController {

    public DepartmentController(){
        departmentRepository = new DepartmentRepository();
    }


    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.getAllDepartments();
    }
}
