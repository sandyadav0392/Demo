<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

      function againConfirm(){
         return confirm("Delete this user.");
          }

</script>
</head>
<body>
    
      <a href="registerForm">Add User</a>
          <table border="1"> 
           <thead>
                <tr>
                 
                  <th>Sno.</th>
                  <th>UserName</th>
                  <th>Email</th>
                  <th>Phone</th>
                  <th>Countries</th>
                  <th>Actions</th>
                </tr>
           </thead>
           <tbody>
             <c:forEach items="${users}" var="user" varStatus="index">
                     <tr>
                       
                       <td>${index.count}</td>
                       <td>${user.username}</td>
                       <td>${user.email}</td>
                       <td>${user.phone}</td>
                       <td>${user.countries}</td>
                       <td>
                                <a href="updateRequest?userId=${user.userid}" style="color:white;">Edit</a>
                                &nbsp;
                                <a href="deleteUser?userId=${user.userid}"onclick="return againConfirm()">Delete</a>
                           
                       </td>
                       </tr>
             </c:forEach>
           </tbody>
          </table> 
        
</body>
</html>