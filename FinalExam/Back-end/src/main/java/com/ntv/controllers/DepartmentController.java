package com.ntv.controllers;

import com.ntv.entities.Department;
import com.ntv.entities.dto.DepartmentDto;
import com.ntv.services.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/department/")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "list-departments")
    public List<Department> getListDepartments() {
        return modelMapper.map(departmentService.getListDepartments(),
                new TypeToken<List<DepartmentDto>>(){}.getType());
    }
}
