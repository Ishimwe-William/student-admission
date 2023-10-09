package rw.ac.auca.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.ac.auca.HibernateUtil;
import rw.ac.auca.model.Student;
import rw.ac.auca.model.User;

public class userDao {
    public User createUser(User user){
        Session session = null;
        Transaction tr = null;
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            tr = ss.beginTransaction();
            ss.save(user);
            tr.commit();
            ss.close();
            return user;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public User userLogin(User user){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query<User> query = session.createQuery("FROM User WHERE email = :email and password=:password", User.class);
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            return query.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
