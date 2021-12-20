package com.ntv.utils;

import com.ntv.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static HibernateUtils instance;

    public static HibernateUtils getInstance() {
        if(instance == null){
            instance = new HibernateUtils();
        }
        return instance;
    }

    private HibernateUtils(){
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Group.class);
        //startSession();
    }

    private Configuration configuration;
    private SessionFactory sessionFactory;

    public SessionFactory buildSessionFactory(){
        if (sessionFactory == null || sessionFactory.isClosed()){
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public Session startSession(){
        buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void shutdownSessionFactory(){
        if(sessionFactory.isOpen() && sessionFactory != null){
            sessionFactory.close();
        }
    }
}
