<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Details of the User</h3>
<c:set var="user" value="${obj }"></c:set>
UserID: ${user.id}
<br> Name: ${user.name }
<br> Salary: ${user.salary }
<br>
<br>
<h3>You can update any UserDetails here</h3>
<form action="success">
user id : <input type="text" name="id"><br> <br>
Name: <input type="text" name="name"><br> <br>
Salary : <input type="text" name="salary"><br> <br>
<input type="submit" value="submit">
</form>
</body>
</html>