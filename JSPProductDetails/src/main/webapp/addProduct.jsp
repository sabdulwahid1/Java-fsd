<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add Products</h1>

<form action="ProductController" method="post">

<label>Enter product name</label>
<input type="text" name="pname"> <br> <br>

<label>Enter product price</label>
<input type="number" name="price"> <br> <br>

<input type="submit" name="Store Product">
<input type="reset" name="Reset">



</form>

<a href="index.jsp">Back</a>

</body>
</html>