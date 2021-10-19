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
 <% String un=(String)session.getAttribute("username"); %>
 <h3>Welcome <%=un %></h3>
 <table width="300" align="center">
 <tr>
 <td>
  <form action="ProfileServlet" method="post">
  <% session.setAttribute("username",un); %>
  <input type="submit" value="MyProfile">
  </form>
 </td>
 <td>
  <form action="ChangePassword.jsp" method="post">
  <input type="submit" value="ChangePassword">
  </form>
 </td>
 <td>
  <form action="LogoutServlet" method="post">
  <input type="submit" value="Logout">
  </form>
 </td>
 </tr>
 </table>
 </div>
</body>
</html>