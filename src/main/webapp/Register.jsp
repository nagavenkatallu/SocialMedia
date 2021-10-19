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
 <h1>Registration form</h1>
 <form action="RegisterServlet" method="post">
 <table style="with: 100%">
 <tr>
 <td><h3>Enter your details</h3></td>
 </tr>
 <tr>
 <td>First name:</td>
 <td><input type="text" name="firstname" /></td>
 </tr>
 <tr>
 <td>Last name:</td>
 <td><input type="text" name="lastname" /></td>
 </tr>
 <tr>
 <td>Username:</td>
 <td><input type="text" name="username" /></td>
 </tr>
 <tr>
 <td>email:</td>
 <td><input type="email" name="email" /></td>
 </tr>
 <tr>
 <td>Password:</td>
 <td><input type="password" name="password" /></td>
 </tr>
 <tr>
 <td>Re-enter password:</td>
 <td><input type="password" name="reenter"/></td>
 </tr>
 <tr>
 <td>Gender:</td>
 <td><input type="radio" name="gender" value="Male" />Male</td>
 <td><input type="radio" name="gender" value="Female">Female</td>
 </tr>
 <tr>
 <td>Age:</td>
 <td><input type="text" name="age" /></td>
 </tr>
 <tr>
 <td><input type="submit" value="Register" /></td>
 </tr>
 </table>
 </form>
 </div>
</body>
</html>