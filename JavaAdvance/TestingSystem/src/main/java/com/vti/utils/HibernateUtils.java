package com.vti.utils;


import com.vti.entity.Department;
import com.vti.entity.Position;
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
        configure = new Configuration();
        configure.configure("hibernate.cfg.xml");

        //add entity - Thông báo cho hibernate biết các đối tượng được thêm vào
        configure.addAnnotatedClass(Department.class);
        configure.addAnnotatedClass(Position.class);
    }

    private Configuration configure;
    private SessionFactory sessionFactory;

    private SessionFactory buildSessionFactory(){
        if(sessionFactory == null || sessionFactory.isClosed()){
            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();

            sessionFactory = configure.buildSessionFactory(serviceRegistry);
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
