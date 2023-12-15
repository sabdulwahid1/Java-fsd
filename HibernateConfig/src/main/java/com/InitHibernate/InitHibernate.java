package com.InitHibernate;

import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.HibernateUtil;
import com.mysql.cj.xdevapi.SessionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;


/**
* Servlet implementation class InitHibernate
*/
@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
        
        
    /**
* @see HttpServlet#HttpServlet()
*/
    public InitHibernate() {
        super();
        // TODO Auto-generated constructor stub
        
    }

   
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                 try {
                         PrintWriter out = response.getWriter();
                         out.println("<html><body>");

                         SessionFactory factory = HibernateUtil.getSessionFactory();
                                
                         Session session = factory.openSession();
                         out.println("Hibernate Session opened.<br>");
                         session.close();
                         out.println("Hibernate Session closed.<br>");
                                
                         out.println("</body></html>");
                            
                             
                         } catch (Exception ex) {
                                 throw ex;
                         }

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}
