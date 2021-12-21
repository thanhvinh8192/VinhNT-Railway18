package com.ntv;

import com.ntv.container.DIContainer;
import com.ntv.controller.DepartmentController;
import org.json.JSONObject;

public class Program {
    public static void main(String[] args) {
        System.out.println("Buoi 10 DEMO Dependency Injection");

        DIContainer diContainer = new DIContainer();

        DepartmentController departmentController = diContainer.initDepartmentController();
        JSONObject jsonObject = departmentController.getDepartments();
        System.out.println(jsonObject.toString());
    }

}
