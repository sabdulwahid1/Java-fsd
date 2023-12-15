<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/add-product" method="post">
        <!-- Form fields for product information -->
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="price">Product Price:</label>
        <input type="text" id="price" name="price" required><br>

        <!-- Add more fields as needed -->

        <input type="submit" value="Add Product">
    </form>
</body>
</html>