package com.ntv.controllers;


import com.ntv.dto.EmployeeDTO;
import com.ntv.services.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("employees")
    public List<EmployeeDTO> getListEmployees(){

//        List<Employee> employeeList = employeeService.getListEmployees();
//
//        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
//
//        for (Employee ep : employeeList){
//            EmployeeDTO employeeDTO = new EmployeeDTO(ep.getEmployeeName(), ep.getDepartment().getDepartmentName());
//            employeeDTOList.add(employeeDTO);
//        }
//        return employeeDTOList;

        return modelMapper.map(employeeService.getListEmployees(),
                new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    @GetMapping("employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "id") int id){
        return modelMapper.map(employeeService.getEmployeeById(id),EmployeeDTO.class);
    }
}
