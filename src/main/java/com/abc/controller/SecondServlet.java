package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Collecting Request Parameters from Request Object
		String pcost = request.getParameter("pcost");
		String pqty = request.getParameter("pqty");

		// Creating a cookie Object on Client Side
		Cookie c3 = new Cookie("pcost", pcost);
		Cookie c4 = new Cookie("pqty", pqty);

		// To add a Cookie to the response object
		response.addCookie(c3);
		response.addCookie(c4);
		
		// Forwarding the request from client side
		RequestDispatcher rd = request.getRequestDispatcher("/Form3.html");
		rd.include(request, response);
	}

}
