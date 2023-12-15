package com.loginServlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hard-coded values for demonstration purposes
        String correctUsername = "demo";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Successful login, redirect to dashboard
            response.sendRedirect("dashboard.jsp");
        } else {
            // Incorrect login, forward to error page
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Perform any logout logic if needed
        // For simplicity, just redirect back to the login page
        response.sendRedirect("login.jsp");
    }
}
