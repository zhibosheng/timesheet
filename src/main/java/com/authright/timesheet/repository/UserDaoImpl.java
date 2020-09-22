package com.authright.timesheet.repository;


import com.authright.timesheet.model.User;
import com.authright.timesheet.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class UserDaoImpl implements UserDao,{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User save(User user){
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        if (user!=null) logger.info(String.format("The user %s was inserted into the table.", user.toString()));

        return user;
    }

    @Override
    public User update(User user){
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            session.persist(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        if (user!=null) logger.debug(String.format("The user %s was updated.", user.toString()));
        return user;
    }

    @Override
    public synchronized User getUserByName(String userName) {
        if (userName == null) return null;

        String hql = "FROM User where lower(userName) = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("name", userName.toLowerCase());

            User user = query.uniqueResult();
            if (user != null) {
                logger.debug(user.toString());
            }
            return user;
        }
    }

    @Override
    public User getUserById(long userId) {

        String hql = "FROM User where userId = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("id", userId);

            User user = query.uniqueResult();
            if (user != null) {
                logger.debug(user.toString());
            }
            return user;
        }
    }

    @Override
    public User getUserByEmail(String email) {

        String hql = "FROM User where lower(email) = :email";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase());

            User user = query.uniqueResult();
            if (user != null) {
                logger.debug(user.toString());
            }
            return user;
        }
    }

    @Override
    public User getUserByPhone(String phone) {

        String hql = "FROM User where phone = :phone";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("phone", phone);

            User user = query.uniqueResult();
            if (user != null) {
                logger.debug(user.toString());
            }
            return user;
        }
    }
}
