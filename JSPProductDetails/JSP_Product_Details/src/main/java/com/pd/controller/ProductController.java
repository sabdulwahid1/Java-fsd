package com.pd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pd.entity.Product;
import com.pd.service.ProductService;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService ps = new ProductService();
		
		List<Product> listofProduct = ps.retriveAllProduct();
		
		 HttpSession hs = request.getSession(); 
		 
		 hs.setAttribute("product", listofProduct);
		 
		 response.sendRedirect("displayProduct.jsp");
		 
		 response.setContentType("text/html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String pname = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Product p = new Product();
		
		p.setPname(pname);
		p.setPrice(price);
		
		ProductService ps = new ProductService();
		
		String result = ps.storeProduct(p);
		
		out.println(result);
		
		RequestDispatcher rs = request.getRequestDispatcher("addProduct.jsp");
		rs.include(request, response);
		response.setContentType("text/html");
		
	}

}
