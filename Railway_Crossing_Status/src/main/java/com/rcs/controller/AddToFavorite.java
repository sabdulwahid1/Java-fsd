package com.rcs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToFavorite
 */
@WebServlet("/AddToFavorite")
public class AddToFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavorite() {
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
		PrintWriter out = response.getWriter();
		
		try{ 
			 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","abdul123@");
			
			String itemId = request.getParameter("itemId");
			
			String sql = "INSERT INTO favorites (id, Name, Address, Landmark, Trainschedule, pname, status) " + "SELECT id, Name, Address, Landmark, Trainschedule, pname, status " + "FROM adminhome WHERE id = ?";
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, itemId);
			
			int rowsAffected = statement.executeUpdate();
			
			statement.close(); 
			con.close();
			response.sendRedirect("userhome.jsp");
			
			
			
		}catch(Exception e) {
			
			out.println(e);
			
		}
	}

}
