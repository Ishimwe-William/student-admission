package rw.ac.auca.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.*;
import rw.ac.auca.model.Student;
import rw.ac.auca.HibernateUtil;

import java.io.IOException;


@WebServlet(name = "AdmissionServlet", urlPatterns = "/secure/submit")
public class AdmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Student student = createStudentFromRequest(req);
            saveStudent(student,req,resp);
            resp.sendRedirect("/success.jsp"); // You can create a success page
        } catch (Exception e) {
            handleException(req, resp, e);
        }
    }

    private Student createStudentFromRequest(HttpServletRequest req) {
        Student student = new Student();
        student.setFullName(req.getParameter("theName"));
        student.setEmail(req.getParameter("theEmail").trim());
        student.setPhone(req.getParameter("the_phone"));
        student.setParent(req.getParameter("the_parent"));
        student.setDob(req.getParameter("the_dob"));
        student.setParPhone(req.getParameter("the_parent_phone"));
        student.setMajor(req.getParameter("majorFac"));
        student.setInvite(req.getParameter("the_invite"));
        student.setLikesArray(req.getParameterValues("how_like"));
        student.setMessage(req.getParameter("message"));
        return student;
    }

    private void saveStudent(Student student, HttpServletRequest req, HttpServletResponse resp) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Student existingStudent = viewStudent(student.getEmail());
            if (existingStudent == null) {
                session.save(student); // Save the new student
            } else {
                req.setAttribute("error", "A student with that email already exists!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
                dispatcher.forward(req, resp);
                return; // Return from the method to prevent further processing
            }

            transaction.commit();
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }
    }
    private void deleteStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }
    private Student viewStudent(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Query the database to retrieve the student with the specified email
            Query<Student> query = session.createQuery("FROM Student WHERE email = :email", Student.class);
            query.setParameter("email", email);
            return query.uniqueResult(); // Returns the student or null if not found
        }
    }


    private void handleException(HttpServletRequest req, HttpServletResponse resp, Exception e)
            throws ServletException, IOException {
        e.printStackTrace();
        req.setAttribute("error", "An error occurred while saving the student data.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, resp);
    }
}