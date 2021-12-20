package com.ntv.repository;

import com.ntv.entity.Article;
import com.ntv.entity.Department;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleRepository {
    private HibernateUtils hibernateUtils;


    public ArticleRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createArticle(Article article){
        Session session = null;
        try{
            session = hibernateUtils.openSession();

            session.getTransaction().begin();
            session.save(article);

            session.getTransaction().commit();

        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

    @SuppressWarnings("unchecked")
    public  int getCountByType(String articleType){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            //session.beginTransaction();
            String sql = "SELECT COUNT(*) FROM Article WHERE type = :nameParameter";
            Query<Long> query = session.createQuery(sql);
            query.setParameter("nameParameter", articleType);
            //session.getTransaction().commit();
            return query.uniqueResult().intValue();
        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

    public List<Article> getAllArticles() {
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Article> query = session.createQuery("FROM Article");
            return query.getResultList();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }
}
