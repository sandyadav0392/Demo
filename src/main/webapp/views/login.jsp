<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('my2.jpg');">
       <h1 style="color:white;font-style: oblique; background: hotpink;"><center>WelCome To  Home Page </center></h1>  
         <h1>Registration Form Page</h1>
         <p>
            <b style="color:green;">${msg}</b>
         </p>
       <table>
        <form:form action="login" modelAttribute="user" method="POST">
           <tr style="color:red;">
            <td>Username</td>
            <td><form:input  path="username"/></td>
           </tr>
           <tr>
            <td>Password</td>
            <td><form:password path="password"/></td>
           </tr>
           <tr>
            <td>E-mail</td>
            <td><form:input path="email"/></td>
           </tr>
           <tr>
            <td>Phone</td>
            <td><form:input path="phone"/></td>
           </tr>
           <tr>
            <td><input type="reset" value="Reset"></td>
            <td><input type="submit" value="Register"></td>
           </tr>
        </form:form>
       </table>
</body>
</html>