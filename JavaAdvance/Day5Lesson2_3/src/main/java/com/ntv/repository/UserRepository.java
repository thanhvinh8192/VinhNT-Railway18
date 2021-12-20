package com.ntv.repository;

import com.ntv.entity.User;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;

public class UserRepository {
    private HibernateUtils hibernateUtils;
    public UserRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createUser(User user){
        Session session = null;
        try{
            session = hibernateUtils.openSession();

            session.getTransaction().begin();
            session.save(user);

            session.getTransaction().commit();

        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }
}
