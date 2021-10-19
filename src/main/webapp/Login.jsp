<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 <h1>Login form</h1>
 <form action="LoginServlet" method="post">
 <table style="with: 100%">
 <tr>
  <td>Username:</td>
  <td><input type="text" name="username" /> </td>
 </tr>
 <tr>
  <td>Password</td>
  <td><input type="password" name="password" /></td>
 </tr>
 <tr>
 <td> <input type="submit" value="Login" /> </td>
 <td> <a href="Register.jsp"> Register </a></td>
 </tr>
 <tr>
 <td><a href="ForgotPassword.jsp">Forgot Password</a></td>
 </tr>
 </table>
   
 </form>
 </div>
</body>
</html>