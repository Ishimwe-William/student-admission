package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.ac.auca.HibernateUtil;
import rw.ac.auca.model.Teacher;

import static rw.ac.auca.HibernateUtil.*;

public class TeacherDao {
    public Teacher createTeacher(Teacher teacher) {
        Transaction tr = null;
        Session ss = null;
        try {
            ss = getSessionFactory().openSession();
            tr = ss.beginTransaction();
            ss.save(teacher);
            tr.commit();
            ss.close();
            return teacher;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }
    public Teacher updateTeacher(Teacher teacher){
        return null;
    }
}
