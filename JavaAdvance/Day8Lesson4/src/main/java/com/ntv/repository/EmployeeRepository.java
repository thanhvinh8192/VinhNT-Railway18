package com.ntv.repository;

import com.ntv.entity.ContractEmployee;
import com.ntv.entity.RegularEmployee;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;

public class EmployeeRepository {

    private HibernateUtils hibernateUtils;

    public EmployeeRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createContractEmployee(ContractEmployee contractEmployee){
        Session session = null;
        try {
            session = hibernateUtils.openSession();;
//            session.beginTransaction();
            session.save(contractEmployee);
//            session.getTransaction().commit();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

    public void createRegularEmployee(RegularEmployee regularEmployee){
        Session session = null;
        try {
            session = hibernateUtils.openSession();;
//            session.beginTransaction();
            session.save(regularEmployee);
//            session.getTransaction().commit();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

}
