package com.ProductDetailsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the product ID from the form
        int productId = Integer.parseInt(request.getParameter("productId"));

        // Fetch product details from the database
        String url = "jdbc:mysql://localhost:3306/mydb_e_commerce";
        String username = "root";
        String password = "abdUL123@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            PrintWriter out = response.getWriter();

            // Display product details
            if (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");

                out.println("<html><body>");
                out.println("<h2>Product Details</h2>");
                out.println("<p>Product ID: " + productId + "</p>");
                out.println("<p>Product Name: " + productName + "</p>");
                out.println("<p>Price: $" + price + "</p>");
                out.println("<p>Description: " + description + "</p>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Product not found</h2>");
                out.println("</body></html>");
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
