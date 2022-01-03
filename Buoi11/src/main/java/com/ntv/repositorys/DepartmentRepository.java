package com.ntv.repositorys;

import com.ntv.entities.Department;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@Repository
public class DepartmentRepository implements IDepartmentRepository {


 @Autowired
    private HibernateUtils hibernateUtils;

    @Override
    public List<Department> getListDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department");
            return query.getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}*/
