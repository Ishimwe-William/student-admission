package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rw.ac.auca.model.Semester;

import java.util.List;
import java.util.UUID;

public class SemesterDao {
    private SessionFactory sessionFactory;

    public SemesterDao() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public void createSemester(Semester semester) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(semester);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception appropriately in your application.
        } finally {
            session.close();
        }
    }

    public Semester getSemesterById(UUID semesterId) {
        Session session = sessionFactory.openSession();
        Semester semester = session.get(Semester.class, semesterId);
        session.close();
        return semester;
    }

    public List<Semester> getAllSemesters() {
        Session session = sessionFactory.openSession();
        List<Semester> semesters = session.createQuery("FROM Semester", Semester.class).list();
        session.close();
        return semesters;
    }

    public void updateSemester(Semester semester) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(semester);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception appropriately in your application.
        } finally {
            session.close();
        }
    }

    public void deleteSemester(UUID semesterId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Semester semester = session.get(Semester.class, semesterId);
            if (semester != null) {
                session.delete(semester);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception appropriately in your application.
        } finally {
            session.close();
        }
    }
}

