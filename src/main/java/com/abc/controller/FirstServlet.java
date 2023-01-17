package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Collecting Parameters from request object
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");

		// Creating Cookie object at Client Side
		Cookie c1 = new Cookie("pid", pid);
		Cookie c2 = new Cookie("pname", pname);

		// To add a Cookie to the response object
		response.addCookie(c1);
		response.addCookie(c2);

		// Forwarding the request from client side
		RequestDispatcher rd = request.getRequestDispatcher("/Form2.html");
		rd.include(request, response);
	}

}
