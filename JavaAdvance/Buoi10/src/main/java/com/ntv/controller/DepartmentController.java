package com.ntv.controller;

import com.ntv.service.IDepartmentService;
import org.json.JSONObject;

public class DepartmentController {

    private IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService){
        this.departmentService = departmentService;
    }

    public JSONObject getDepartments() {
        return departmentService.getDepartments();
    }
}
