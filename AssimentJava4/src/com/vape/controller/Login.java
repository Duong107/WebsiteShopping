package com.vape.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vape.DAO.UserDao;
import com.vape.entity.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Profile")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null&&session.getAttribute("user")!="admin") {
			//load profile
			String user = session.getAttribute("user").toString();
			Users e = new UserDao().selectById(user);
			request.setAttribute("E", e);
			request.setAttribute("active", "");
			request.getRequestDispatcher("/JSP/profile.jsp").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			doGet(request, response);
		}

}
