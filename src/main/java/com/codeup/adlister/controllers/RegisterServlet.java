package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isNotBlank = !username.isEmpty() && !email.isEmpty() && !password.isEmpty();
        User userCk = DaoFactory.getUsersDao().findByUsername(username);
        if (isNotBlank && userCk == null) {
            User user = new User(
                    username,
                    email,
                    password
            );
            DaoFactory.getUsersDao().insert(user);
            userCk = user;
            request.getSession().setAttribute("userCk", userCk);
            response.sendRedirect("/profile");
            return;
        } else {
            //response.sendRedirect("/register");
            String msg=  "Sorry !! You have an error. Please ensure all fields are filled out properly";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        }
    }
}
