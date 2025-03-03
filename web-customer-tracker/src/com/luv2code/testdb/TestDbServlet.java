package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		// set up connection variables
		
		String user = "springstudent";
		
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to database
		
		try
		{
			
			PrintWriter out = response.getWriter();
			
			out.println("\n  Connecting to Database : "+jdbcUrl);
			
			Class.forName(driver);
			
			out.println();
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("\n SUCCESS !!!");
			
			myConn.close();
			
			
			
		} 
		catch (Exception exc) 
		{
		
			exc.printStackTrace();
			
			throw new ServletException(exc);
		}
		
	}

}
