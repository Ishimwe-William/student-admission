package rw.ac.auca.controller.studentadmission;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rw.ac.auca.dao.userDao;
import rw.ac.auca.model.User;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    userDao dao=new userDao();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=userRequest(req);
        User newUser=dao.userLogin(user);
        if(newUser==null){
            req.setAttribute("error", "User not found.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            try {
                resp.sendRedirect("/index.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private User userRequest(HttpServletRequest request){
        User user=new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
}
