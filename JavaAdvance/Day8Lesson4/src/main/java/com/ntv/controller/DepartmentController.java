package com.ntv.controller;

import com.ntv.entity.Department;
import com.ntv.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "departments/")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(){
        departmentService = new DepartmentService();
    }

    @GetMapping(value = "show-list-departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void  deleteDepartmentByIt(@RequestParam("id") int id){
        //System.out.println("delete by id: " + id);
        departmentService.deleteDepartmentByIt(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int  createDepartment(@RequestParam("departmentName") String departmentName, @RequestParam("created_at") String createdAt){
        LocalDate createdDate = LocalDate.parse(createdAt);

        Department department = new Department();
        department.setDepartmentName(Department.DepartmentNameEnum.toEnum2(departmentName));
        department.setCreatedAt(createdDate);

        return departmentService.createDepartment(department);
    }

    @RequestMapping(value =  "/update", method = RequestMethod.POST)
    public void  updateDepartment(@RequestParam("id") int id, @RequestParam("departmentName") String departmentName, @RequestParam("created_at") String createdAt){
        LocalDate createdDate = LocalDate.parse(createdAt);

        Department department = new Department();
        department.setId(id);
        department.setDepartmentName(Department.DepartmentNameEnum.toEnum2(departmentName));
        department.setCreatedAt(createdDate);

        departmentService.updateDepartment(department);
    }

}
