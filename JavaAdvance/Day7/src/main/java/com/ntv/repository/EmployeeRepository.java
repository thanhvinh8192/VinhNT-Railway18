package com.ntv.repository;

import com.ntv.entity.Employee;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {

    HibernateUtils hibernateUtils;
    public EmployeeRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getListEmployees(){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Employee> query = session.createQuery("FROM Employee");
            return query.getResultList();
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }
}
