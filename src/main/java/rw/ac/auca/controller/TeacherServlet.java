package rw.ac.auca.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rw.ac.auca.dao.TeacherDao;
import rw.ac.auca.model.EQualification;
import rw.ac.auca.model.Teacher;

import java.io.IOException;

@WebServlet("/teacherServlet")
public class TeacherServlet extends HttpServlet {
    TeacherDao dao=new TeacherDao();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher newTeacher=dao.createTeacher(teacherRequest(req));
        if(newTeacher==null){
            req.setAttribute("error", "Error while creating teacher");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            resp.sendRedirect("success.jsp");
        }

    }

    private Teacher teacherRequest(HttpServletRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getParameter("name"));
        teacher.setDob(request.getParameter("dob"));
        teacher.setGender(request.getParameter("gender"));
        teacher.setDegree(EQualification.valueOf(request.getParameter("degree")));
        teacher.setEmail(request.getParameter("email").toLowerCase());
        teacher.setPhone(request.getParameter("phone"));

        // Check which type is selected
        String selectedType = request.getParameter("teacherType");
        if ("Tutor".equals(selectedType)) {
            teacher.setType("Tutor");
        } else if ("Assistant Tutor".equals(selectedType)) {
            teacher.setType("Assistant Tutor");
        }

        return teacher;
    }

}
