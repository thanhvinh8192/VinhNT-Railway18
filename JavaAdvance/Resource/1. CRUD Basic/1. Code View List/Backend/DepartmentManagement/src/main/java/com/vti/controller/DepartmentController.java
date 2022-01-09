package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
		List<Department> entities = service.getAllDepartments();

		List<DepartmentDto> dtos = new ArrayList<>();

		// convert entities --> dtos
		for (Department entity : entities) {
			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(),
					new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()),
					entity.getCreateDate());
			dtos.add(dto);
		}

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
//		return new ResponseEntity<Department>(service.getDepartmentByID(id), HttpStatus.OK);
//	}
//
//	@PostMapping()
//	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {
//		service.createDepartment(dto.toEntity());
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto) {
//		Department department = dto.toEntity();
//		department.setId(id);
//		service.updateDepartment(department);
//		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
//		service.deleteDepartment(id);
//		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
//	}
}
