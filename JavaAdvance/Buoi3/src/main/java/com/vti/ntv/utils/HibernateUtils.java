package com.vti.ntv.utils;

import com.vti.ntv.entities.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static   HibernateUtils instance;
    public static HibernateUtils getInstance() {
        if (instance == null){
            instance = new HibernateUtils();
        }
        return instance;
    }
    private HibernateUtils(){
        //load configuration
       configuration = new Configuration();
       configuration.configure("hibernate.cfg.xml");

        //add entity - Thông báo cho hibernate biết các đối tượng được thêm vào
        configuration.addAnnotatedClass(Department.class);
    }

    private Configuration configuration;
    private SessionFactory sessionFactory;

    private SessionFactory buildSessionFactory(){
        if(sessionFactory == null || sessionFactory.isClosed()){
            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
    public Session openSession(){
        buildSessionFactory();
        return sessionFactory.openSession();
    }
    public void closeSessionFactory(){
        if (sessionFactory.isOpen() && sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
