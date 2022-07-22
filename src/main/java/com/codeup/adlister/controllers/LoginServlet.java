package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("userCk") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User userCk = DaoFactory.getUsersDao().findByUsername(username);
        if (userCk != null) {
            boolean validAttempt = userCk.getUsername().equalsIgnoreCase(username) && userCk.getPassword().equals(password);
            if (validAttempt) {
                request.getSession().setAttribute("userCk", userCk);
                response.sendRedirect("/profile");
            } else {
                // response.sendRedirect("/login");
                String msg = "Sorry !! You have an error. Please ensure all fields are filled out properly";
                request.getSession().setAttribute("msg", msg);//setting attribute
                // forwards message to your page
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            // response.sendRedirect("/login");
            String msg = "Sorry!! This user is not yet registered.";
            request.getSession().setAttribute("msg", msg);//setting attribute
            // forwards message to your page
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
