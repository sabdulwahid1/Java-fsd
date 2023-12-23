<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Register Form</title>
<style type="text/css">

div{
 margin: auto;
  width: 50%;
  border: 3px solid red;
  padding: 100px;


}

</style>
</head>
<body>
<div align="center">
<form action="Register" method="post"> 

 <h2>User Registration</h2> 
 
<table>
 
 <tr> 
	 <td>Name:</td> 
	 <td><input type="text" name="uname" placeholder="UserName" required></td> 
 </tr>
 
 <tr> 
	 <td>Email:</td> 
	 <td><input type="text" name="email" placeholder="Email" required></td> 
 </tr>
 
 <tr> 
 	<td>Password:</td> 
 	<td><input type="password" name="password" placeholder="password" required></td> 
 </tr> 
 
 <br> <br>
 
 <tr> 
	 <td></td> 
	 <td><input type="submit" value="register"><br> 
	 <br>Already Registered?
	 <a href="login.jsp">Go to login</a>
	 </td> 
 </tr>
 
 </table>
 
 </form>
</div>
</body>
</html>