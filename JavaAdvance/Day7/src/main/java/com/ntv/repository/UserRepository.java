package com.ntv.repository;

import com.ntv.entity.User;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    HibernateUtils hibernateUtils;

    public UserRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<User> getListUsers(){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<User> query = session.createQuery("FROM User");
            return query.getResultList();
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }
}
