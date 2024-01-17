<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Available Users </h1>
<table border=1 cellspacing=0 cellpadding=10>
<tr><th>ID</th><th>NAME</th><th>SALARY</th></tr>
<c:forEach var="p" items="${list }">
<tr>
<td>${p.id }</td>
<td>${p.name }</td>
<td>${p.salary }</td>
</tr>
</c:forEach>
</table>
</body>
</html>