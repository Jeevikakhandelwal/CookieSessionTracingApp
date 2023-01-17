package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.Product;
import com.abc.dto.ProductDto;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting the MIME Type
		response.setContentType("text/html");

		// Collecting Request Parameters from Request Object
		String mdate = request.getParameter("mdate");
		String edate = request.getParameter("edate");

		// Getting all the cookies
		Cookie[] cookies = request.getCookies();
		String pid = cookies[0].getValue();
		String pname = cookies[1].getValue();
		Integer pcost = Integer.parseInt(cookies[0].getValue());
		Integer pqty = Integer.parseInt(cookies[0].getValue());

		//
		Product product = new Product();
		product.setPid(pid);
		product.setPname(pname);
		product.setPcost(pcost);
		product.setPqty(pqty);
		product.setMdate(mdate);
		product.setEdate(edate);

		System.out.println(product);
		
		ProductDto productDto = new ProductDto();
		String status = productDto.registerProduct(product);

		RequestDispatcher rd = null;
		if (status.equals("success")) {
			rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("failure.html");
			rd.forward(request, response);
		}
	}

}
