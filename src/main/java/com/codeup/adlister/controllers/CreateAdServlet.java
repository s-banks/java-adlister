package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("msg");
		request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User searchedUser = (User)request.getSession().getAttribute("user");
		if (request.getSession().getAttribute("user") != null) {
			Ad ad = new Ad(
					searchedUser.getId(),
					request.getParameter("title"),
					request.getParameter("description")
			);
			DaoFactory.getAdsDao().insert(ad);
			response.sendRedirect("/ads");
		} else {
			String msg = "Sorry, you must be logged in to post an add.";
			request.getSession().setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
		}
	}
}
