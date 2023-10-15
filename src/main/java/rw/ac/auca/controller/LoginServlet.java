package rw.ac.auca.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import rw.ac.auca.dao.UserDao;
import rw.ac.auca.model.User;
import rw.ac.auca.service.Mailer;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao dao = new UserDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userRequest(req);
        User newUser = dao.userLogin(user);

        if (newUser == null) {
            req.setAttribute("error", "User not found.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession(true); // Create a new session if it doesn't exist
            session.setMaxInactiveInterval(60); // Set session timeout to 60 seconds (1 minute)
            session.setAttribute("user", newUser);
            resp.sendRedirect("index.jsp"); // Redirect to index.jsp
        }
    }

    private User userRequest(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}

