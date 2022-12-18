package com.app.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   //Define datasource/connection pool for Resource Injection   
   @Resource(name="jdbc/web_student_tracker")
   private DataSource dataSource;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// step 1 : set up the printwriter
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// step 2 : Get a connection to the database
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con=dataSource.getConnection();
		// step 3 : Create a SQL statements
		String sQry ="select * from student";
		stmt =con.createStatement();
		
		// step 4 : Execute SQL query
		rs = stmt.executeQuery(sQry);
		
		// step 5 : Process the result set
				while(rs.next()) {
					String email = rs.getString("email");
					out.println(email);
				}
		}
		catch(Exception e) {
			e.printStackTrace();
			out.println("Exception !!!!!");
		}
		
	}


}
