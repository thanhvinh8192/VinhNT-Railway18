package com.ntv.entities.dto;

import com.ntv.entities.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class DepartmentDto implements Serializable {
    @NonNull
    private  int id;

    @NonNull
    private  String departmentName;

    @NonNull
    private  int totalMember;

    @NonNull
    private  Department.DepartmentTypeEnum type;

    @NonNull
    private  Date createdDate;
}
