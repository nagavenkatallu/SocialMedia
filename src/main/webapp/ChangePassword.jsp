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
 <form action="ChangeServlet" method="post">
 <table align="center" border=1 width=500>
 <tr>
  <% String username=(String)session.getAttribute("username"); %>
  <h4>Hello <%= username %>.Please enter new password</h4>
 </tr>
 <tr>
  <td>New Password:</td>
  <td><input type="password" name="password"></td>
 </tr>
 <tr>
  <td>Re-enter Password:</td>
  <td><input type="password" name="reenter"></td>
 </tr>
 </table>
 <table align="center">
 <tr>
  <td><input type="submit" value="update"></td>
 </tr>
 </table>
 </form>
 </div>
</body>
</html>