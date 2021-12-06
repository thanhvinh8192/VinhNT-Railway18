package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public Department getDepartmentById(int id){
        try{
            session = hibernateUtils.openSession();
            return session.get(Department.class, id); // trả về đối tượng Department
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Department getDepartmentByName(String departmentName){
        try{
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :nameParameter");
            query.setParameter("nameParameter", departmentName);
            return query.uniqueResult();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    //Insert
    public void createDepartment(Department department){
        try{
            session = hibernateUtils.openSession();
            session.save(department);
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    //Update name department
    public void updateDepartment(int departmentId, String newName){
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = session.load(Department.class, departmentId);
            department.setDepartmentName(newName);
            session.getTransaction().commit();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public void deleteDepartmentById(int departmentId){
        try{
            session = hibernateUtils.openSession();

            Department department =(Department) session.load(Department.class, departmentId);

            session.delete(department);
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }
    //delete persistent object
    public void deleteDepartmentById2(int departmentId){
        Transaction transaction = null;
        try{
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Department department = session.get(Department.class, departmentId);

            /*Department department = new Department(); delete transient object
            department.setDepartmentId(departmentId);*/

            session.delete(department);
            transaction.commit();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public boolean isDepartmentExistsById(int id){
        Department department = getDepartmentById(id);
        return department != null;
    }
    public boolean isDepartmentExistsByName(String name){
        Department department = getDepartmentByName(name);
        return department != null;
    }
}
