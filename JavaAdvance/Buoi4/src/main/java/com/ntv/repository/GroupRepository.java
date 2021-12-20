package com.ntv.repository;

import com.ntv.entity.Group;
import com.ntv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;
    public GroupRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createGroup(Group group){
        Session session = null;
        try{
            session = hibernateUtils.startSession();

            session.getTransaction().begin();
            session.save(group);
            session.getTransaction().commit();
            System.out.println("Group has created!..");
        }
        finally {
            if (session!= null){
                session.close();
            }

        }
    }

    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups(){
        Session session = null;
        try{
            session = hibernateUtils.startSession();
            Query<Group> query = session.createQuery("FROM Group");
            return query.getResultList();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public Group getGroupById(short id){
        Session session = null;
        try{
            session = hibernateUtils.startSession();
            return session.get(Group.class, id); //Trả về một đối tượng có data type là Group
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Group getGroupByName(String groupName){
        Session session = null;
        try{
            session = hibernateUtils.startSession();
            Query<Group> query = session.createQuery("FROM Group WHERE group_name = :nameParameter");
            query.setParameter("nameParameter", groupName);
            return query.uniqueResult();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public void updateGroupNameById(short groupId, String newGroupName){
        Session session = null;
        try{
            //get session
            session = hibernateUtils.startSession();
            session.beginTransaction();

            //update
            Group group = session.load(Group.class, groupId);
            group.setGroupName(newGroupName);
            session.getTransaction().commit();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public void updateGroupInfoById(short groupID, Group group){
        Session session = null;
        try{
            //get session
            session = hibernateUtils.startSession();
            session.beginTransaction();

            //update
            group.setGroupId(groupID);
            session.update(group);
            session.getTransaction().commit();
            System.out.println("Updated successfull!...");
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public void deleteGroupById(short id){
        Session session = null;
        try{
            //get session
            session = hibernateUtils.startSession();
            session.beginTransaction();

            Group group = session.load(Group.class, id);
            session.delete(group);
            session.getTransaction().commit();
        }
        finally {
            if (session!= null){
                session.close();
            }
        }
    }


}
