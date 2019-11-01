<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script>
 $(function(){
	  $("#header").load("header.html"); 
 });
 </script>
 <style type="text/css">
  body {
          background-image: url('images/my4.jpg');
  }
 </style>
</head>
<body>
          <%@include file="homeHeader.jsp" %>
                     <p style="text-align: right; font-size: 20px;"> <img src="images/user1.png" height="50px" width="50px" style="border-radius: 100px; top: -100px;">${name}</p>
            <table>
                <tr>
                 <td><img src="images/test2.jpg" height="200px" width="50%" style="border-radius: 100px; top: -100px;"></td>
                 <td><img src="images/test7.jpg" height="200px" width="50%" style="border-radius: 100px; top: -100px;"></td>
                </tr>
                
            
            </table>
         <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <%@include file="footer.jsp" %> 
</body>
</html>
