package com.ntv.repository;

import com.ntv.entity.Department;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {

    private HibernateUtils hibernateUtils;


    public DepartmentRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createDepartment(Department department){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            //session.getTransaction().begin();
            session.save(department);
            //session.getTransaction().commit();

        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

    public List<Department> getAllDepartments() {
        Session session = null;
        try{
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department");
            return query.getResultList();
        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

    @SuppressWarnings("unchecked")
    public  int getCountByName(String departmentName){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            //session.beginTransaction();
            String sql = "SELECT COUNT(*) FROM Department WHERE name = :nameParameter";
            Query<Long> query = session.createQuery(sql);
            query.setParameter("nameParameter", departmentName);
            //session.getTransaction().commit();
            return query.uniqueResult().intValue();
        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

}
