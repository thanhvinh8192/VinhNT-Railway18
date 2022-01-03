package com.ntv.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentNameConverter implements AttributeConverter<com.ntv.entities.Department.DepartmentNameEnum, String> {

    @Override
    public String convertToDatabaseColumn(com.ntv.entities.Department.DepartmentNameEnum departmentNameEnum) {
        if (departmentNameEnum != null) return departmentNameEnum.getName();
        return null;
    }

    @Override
    public Department.DepartmentNameEnum convertToEntityAttribute(String dbData) {
        if (dbData != null) return  com.ntv.entities.Department.DepartmentNameEnum.toEnum(dbData);
        return null;
    }
}
