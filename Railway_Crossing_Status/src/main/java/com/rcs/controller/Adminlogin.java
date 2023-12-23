package com.rcs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		try{ 
			 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","abdul123@");
			
			String uname = request.getParameter("uname"); 
			String pass = request.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE uname=? AND password=?"); 
			ps.setString(1,uname); 
			ps.setString(2,pass); 
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) { 
				RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp"); 
				rd.forward(request, response); 
			}else {
				
				out.println("<font color=red size=5>Login Failed<br>"); 
				out.println("<font color=red size=3>Invalid user name or password<br>"); 
				out.println("<a href=login.jsp> Please Try Again </a>");
				
			}
				
			}catch(Exception e) {
				
				out.println(e);
				
			}
		
	}

}

