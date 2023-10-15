package rw.ac.auca.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import rw.ac.auca.dao.CourseDefinitionDao;
import rw.ac.auca.model.CourseDefinition;

import java.io.IOException;

@WebServlet("/courseDefinitionServlet")
public class CourseDefinitionServlet extends HttpServlet {

    CourseDefinitionDao dao=new CourseDefinitionDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDefinition newCourseDescription = dao.createCourseDefinition(semesterRequest(req));
        if (newCourseDescription == null) {
            req.setAttribute("error", "Error while creating course description");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("success.jsp");
        }

    }

    private CourseDefinition semesterRequest(HttpServletRequest request) {
        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setCode(request.getParameter("code").toUpperCase());
        courseDefinition.setName(request.getParameter("name"));
        courseDefinition.setDescription(request.getParameter("description"));
        return courseDefinition;
    }
}
