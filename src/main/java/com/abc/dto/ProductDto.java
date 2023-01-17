package com.abc.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.dao.Product;

public class ProductDto {

	private static final String SQL_INSERT_QUERY = "insert into product(pid,pname,pcost,pqty,mdate,edate) values(?,?,?,?,?,?)";
	Connection connection = null;
	PreparedStatement pstmt = null;

	public ProductDto() {

		try {
			// JVM Present in Server will not support auto loading so manually load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///PersonInfo", "root", "root");
			pstmt = connection.prepareStatement(SQL_INSERT_QUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String registerProduct(Product product) {

		try {

			pstmt.setString(1, product.getPid());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getPcost());
			pstmt.setInt(4, product.getPqty());
			pstmt.setString(5, product.getMdate());
			pstmt.setString(6, product.getEdate());

			int rowCount = pstmt.executeUpdate();

			if (rowCount > 0) {
				return "success";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";

	}

}
