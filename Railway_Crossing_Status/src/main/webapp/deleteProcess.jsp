<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.io.*,java.util.*,java.sql.*"%> 
    <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Process</title>
</head>
<body>
<% 

String id = request.getParameter("id"); 

if (id != null && !id.isEmpty()) {
	
	try { 
		String url = "jdbc:mysql://localhost:3306/railway"; 
		String user = "root"; 
		String password = "abdul123@";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "DELETE FROM adminhome WHERE id = ?"; 
		
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, id); 
		pstmt.executeUpdate();
		
		pstmt.close(); 
		conn.close(); 
		
		response.sendRedirect("delete.jsp?success=true");
		
	}catch (SQLException e) { 
		e.printStackTrace();
		response.sendRedirect("delete.jsp?error=true");
	}
} else{
	
	response.sendRedirect("delete.jsp?error=true");
	
}

%>

</body>
</html>