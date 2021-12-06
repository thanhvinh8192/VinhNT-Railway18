package com.vti.repository;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {

    HibernateUtils hibernateUtils;
    public PositionRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }
    Session session = null;

    @SuppressWarnings("unchecked")
    public List<Position> getAllPosition(){

        try{
            session = hibernateUtils.openSession();
            Query<Position> query = session.createQuery("FROM Position");
           return query.list();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }


}
