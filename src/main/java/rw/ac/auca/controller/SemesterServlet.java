package rw.ac.auca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rw.ac.auca.dao.SemesterDao;
import rw.ac.auca.model.Semester;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet("/semesterServlet")
public class SemesterServlet extends HttpServlet {
    private SemesterDao semesterDao;

    public void init() {
        semesterDao = new SemesterDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            List<Semester> semesters = semesterDao.getAllSemesters();
            request.setAttribute("semesters", semesters);
            request.getRequestDispatcher("/semesterList.jsp").forward(request, response);

        } else if (action.equals("create")) {
            request.getRequestDispatcher("/createSemesterForm.jsp").forward(request, response);

        } else if (action.equals("edit")) {
            UUID semesterId = UUID.fromString(request.getParameter("semester_id"));
            Semester semester = semesterDao.getSemesterById(semesterId);
            request.setAttribute("semesterToEdit", semester);
            request.getRequestDispatcher("/editSemesterForm.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            UUID semesterId = UUID.fromString(request.getParameter("semester_id"));
            Semester semester = semesterDao.getSemesterById(semesterId);
            request.setAttribute("semesterToDelete", semester);
            request.getRequestDispatcher("/deleteSemesterConfirm.jsp").forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action.equals("create")) {
            Semester semester = new Semester();
            semester.setName(request.getParameter("name"));
            semester.setStart_date(request.getParameter("start_date"));
            semester.setEnd_date(request.getParameter("end_date"));
            semesterDao.createSemester(semester);
            response.sendRedirect(request.getContextPath() + "/semesterServlet");
        } else if (action.equals("update")) {
            UUID semesterId = UUID.fromString(request.getParameter("semester_id"));
            Semester semester = semesterDao.getSemesterById(semesterId);
            semester.setName(request.getParameter("name"));
            semester.setStart_date(request.getParameter("start_date"));
            semester.setEnd_date(request.getParameter("end_date"));
            semesterDao.updateSemester(semester);
            response.sendRedirect(request.getContextPath() + "/semesterServlet");
        }else if(action.equals("confirmDelete")){
            UUID semesterId = UUID.fromString(request.getParameter("semester_id"));
            semesterDao.deleteSemester(semesterId);
            response.sendRedirect(request.getContextPath() + "/semesterServlet");
        }
    }
}