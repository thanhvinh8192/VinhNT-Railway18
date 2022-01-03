package com.ntv.controllers;

import com.ntv.entities.Department;
import com.ntv.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "departments/")

public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping(value = "show-list-departments")
    public List<Department> getListDepartments() {
        return departmentService.getListDepartments();
    }

    @GetMapping(value = "hot-reload")
    public String testHotReload() {
        return "Data";
    }

    @GetMapping("department/{id}")
    public Department findDepartmentById(@PathVariable(name = "id") int id) {
        System.out.println("id to find" + id);
        return departmentService.findDepartmentById(id);
    }

    @GetMapping("department/name/{name}")
    public List<Department> findDepartmentByName(@PathVariable(name = "name") String departmentName) {
        System.out.println("Name to find " + departmentName);
        return departmentService.findDepartmentByName(Department.DepartmentNameEnum.toEnum2(departmentName));
    }


    @RequestMapping(value = "creating", method = RequestMethod.POST)
    public void createDepartment(@RequestBody Department department){
        System.out.println(department);
        departmentService.createDepartment(department);
    }

    @GetMapping(value = "paging")
    public Page<Department> getPagingDepartments(Pageable pageable) {
        return departmentService.getPagingDepartments(pageable);
    }

}
