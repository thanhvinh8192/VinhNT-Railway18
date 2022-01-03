package com.ntv.dto;

import com.ntv.entities.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data @NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {

    @NonNull
    private String employeeName;

    @NonNull
    private Department.DepartmentNameEnum departmentName;
}
