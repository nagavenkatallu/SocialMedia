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
 <form action="ForgotServlet" method="post">
 <table>
 <tr>
  <td>Username:</td>
  <td> <input type="text" name="username"> </td>
 </tr>
 <tr>
  <td>Email:</td>
  <td> <input type="email" name="email"> </td>
 </tr>
 <tr>
  <td>Age:</td>
  <td> <input type="text" name="age"> </td>
 </tr>
 </table>
 <table>
  <tr><input type="submit" value="update"></tr>
 </table>
 </form>
 </div>
</body>
</html>