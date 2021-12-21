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

    public int createDepartment(Department department){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            int idInsert = (int) session.save(department);
            session.getTransaction().commit();
            return idInsert;
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments() {
        Session session = null;
        try{
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department");
            return query.getResultList();
        }
        finally {
            if (session != null){
                session.close();
            }

        }
    }

    public void deleteDepartmentById(int id){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Department department = session.load(Department.class, id);
            session.delete(department);
            session.getTransaction().commit();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    public void updateDepartment(Department department) {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();
            String hql = """
                          UPDATE Department 
                          SET departmentName = :nameParameter, created_at = :createAtParameter
                          WHERE id = :idParameter
                          """;
            Query query = session.createQuery(hql);
            query.setParameter("idParameter", department.getId());
            query.setParameter("nameParameter", department.getDepartmentName());
            query.setParameter("createAtParameter", department.getCreatedAt());

            query.executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }
}
