package com.ntv.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentNameConverter implements AttributeConverter<Department.DepartmentNameEnum, String> {

    @Override
    public String convertToDatabaseColumn(Department.DepartmentNameEnum departmentNameEnum) {
        if (departmentNameEnum != null) return departmentNameEnum.getName();
        return null;
    }

    @Override
    public Department.DepartmentNameEnum convertToEntityAttribute(String dbData) {
        if (dbData != null) return  Department.DepartmentNameEnum.toEnum(dbData);
        return null;
    }
}
