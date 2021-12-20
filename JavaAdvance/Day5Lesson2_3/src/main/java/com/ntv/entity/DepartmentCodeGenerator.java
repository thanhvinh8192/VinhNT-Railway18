package com.ntv.entity;

import com.ntv.repository.DepartmentRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class DepartmentCodeGenerator implements IdentifierGenerator {
    DepartmentRepository departmentRepository;

    public DepartmentCodeGenerator(){
        departmentRepository = new DepartmentRepository();
    }


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Department department = (Department) object;
        String name = department.getDepartmentName().toString();
        int count = departmentRepository.getCountByName("HR");
        count++;
        return name + "-" + (count);
    }
}
