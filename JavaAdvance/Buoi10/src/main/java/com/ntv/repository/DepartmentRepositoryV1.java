package com.ntv.repository;

import org.json.JSONObject;

public class DepartmentRepositoryV1 implements IDepartmentRepository{


    @Override
    public JSONObject getDepartments() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("firstName", "Jhon");
        jsonObject.put("lastName", "Doe");

        return jsonObject;
    }
}
