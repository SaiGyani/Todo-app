package com.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TodoDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int s=Integer.parseInt(request.getParameter("delete"));
		String data = request.getParameter("text");
		String data1 = request.getParameter("destext");
		String dbcon = "jdbc:mysql://localhost:3306/todos";
		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(dbcon, "root", "password");
			PreparedStatement ps = con.prepareStatement("delete from todo where id=?");
			ps.setInt(1, s);
			int n=ps.executeUpdate();
			if(n>0) {
				response.sendRedirect("index.jsp");
			}
	}
		catch (Exception e) {
			out.println(e.getMessage());
		}
	}

}
