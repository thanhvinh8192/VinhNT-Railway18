package com.vti.ntv.repository;

import com.vti.ntv.entities.Department;
import com.vti.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    HibernateUtils hibernateUtils;
    Session session = null;
    public DepartmentRepository(){

        hibernateUtils = HibernateUtils.getInstance();

    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments(){
        try{
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department");
            return query.list();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

}
