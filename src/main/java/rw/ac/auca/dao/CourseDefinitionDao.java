package rw.ac.auca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.ac.auca.HibernateUtil;
import rw.ac.auca.model.CourseDefinition;

public class CourseDefinitionDao {
    public CourseDefinition createCourseDefinition(CourseDefinition courseDefinition) {
        Transaction tr = null;
        try (Session ss = HibernateUtil.getSessionFactory().openSession()) {
            tr = ss.beginTransaction();
            ss.save(courseDefinition);
            tr.commit();
            ss.close();
            return courseDefinition;
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }
    public CourseDefinition updateSemester(CourseDefinition semester) {
        return null;
    }
}
