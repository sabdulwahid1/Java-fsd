<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:forEach var="product" items="${list}">   
   ${product.name}, ${product.price}, ${product.dateAdded}<br>  
 </c:forEach>  

</body>
</html>