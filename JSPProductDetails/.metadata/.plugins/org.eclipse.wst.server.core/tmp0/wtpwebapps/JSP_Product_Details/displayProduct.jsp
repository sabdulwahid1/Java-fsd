<%@page import="java.util.Iterator"%>
<%@page import="com.pd.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Display Products</h1>

<table border = 1>

<tr>

<th> PID </th>
<th> PNAME </th>
<th> PRICE </th>

</tr>

<%
Object obj = session.getAttribute("product");

List<Product> listofProduct = (List<Product>)obj;

Iterator<Product> li = listofProduct.iterator();

while(li.hasNext()){
	Product p = li.next();
	%>
	<tr>
	
	<td> <%=p.getPid() %> </td>
	<td> <%=p.getPname() %> </td>
	<td> <%=p.getPrice() %> </td>
	</tr>
	<% 
}

%>

</table>

<a href="index.jsp">Back</a>
	
</body>
</html>