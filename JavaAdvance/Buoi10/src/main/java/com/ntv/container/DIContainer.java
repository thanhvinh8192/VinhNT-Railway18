package com.ntv.container;

import com.ntv.controller.DepartmentController;
import com.ntv.repository.DepartmentRepositoryV1;
import com.ntv.repository.IDepartmentRepository;
import com.ntv.service.DepartmentService;
import com.ntv.service.IDepartmentService;

public class DIContainer {

    public IDepartmentRepository initDepartmentRepository(){
        return new DepartmentRepositoryV1();
    }

    public DepartmentService initDepartmentService(){
        IDepartmentRepository departmentRepository = initDepartmentRepository();
        return new DepartmentService(departmentRepository);
    }

    public DepartmentController initDepartmentController(){
        IDepartmentService departmentService = initDepartmentService();
        return new DepartmentController(departmentService);
    }
}
