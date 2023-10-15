package rw.ac.auca.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rw.ac.auca.model.User;
import rw.ac.auca.dao.UserDao;

import java.io.IOException;

@WebServlet("/signupServlet")
public class SignUpServlet extends HttpServlet {
    UserDao dao=new UserDao();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=userRequest(req);
        User newUser=dao.createUser(user);
        if(newUser==null){
            req.setAttribute("error", "This email address is already in use. Please choose a different one.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }
        else{
            resp.sendRedirect("/login.jsp");
        }

    }
    private User userRequest(HttpServletRequest request){
        User user=new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}

