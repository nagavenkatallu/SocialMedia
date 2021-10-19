<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% String username=(String)session.getAttribute("username"); %>
 <h5>Hello <%= username %></h5>
 <div align="center">
 <table border="1" width=600 align="center">
 <tr bgcolor="00FF7F">
 <th><b>Name</b></th>
 <th><b>Email</b></th>
 <th><b>Gender/</b></th>
 <th><b>Age</b></th>
 </tr>
 <tr>
 <td><%String name=(String)request.getAttribute("name");%><%= name %></td>
 <td><%String email=(String)request.getAttribute("email");%><%= email %></td>
 <td><%String gender=(String)request.getAttribute("gender");%><%= gender %></td>
 <td><%String age=(String)request.getAttribute("age");%><%= age %></td>
 </tr>
 </table>
 <table align="center">
 <tr>
 <form action="Success.jsp" method="post">
 <input type="submit" value="Home">
 </form>
 </tr>
 </table>
 </div>
</body>
</html>