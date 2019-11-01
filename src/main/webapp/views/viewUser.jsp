<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<script type="text/javascript">
	function againConfirm() {
		return confirm("Delete this user.");
	}
</script>
<style type="text/css">
body {
	background-image: url('images/test7.jpg');
	color: white;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>

 <div>
	<h2>Filterable Table</h2>
<input id="myInput" type="text" placeholder="Search.." style="text-align: center; right: 200px;">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
   	<button>
	<a href="registerForm"><b style="font-size: 20px; height: 20px; width: 60px;">+User</b></a>	
	</button>   
	<table border="1" style="background-color: black; text-align: center;">
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
		<tbody id="myTable">
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>

					<td>${index.count}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.countries}</td>
					<td><a href="updateRequest?userId=${user.userid}"
						style="color: white;">Edit</a> &nbsp; <a
						href="deleteUser?userId=${user.userid}"
						onclick="return againConfirm()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    <c:if test="${cp>1}">
            <a href="viewUsers?page=${cp-1}" style="color: blue;background-color: white; height: 20px; width: 60px;">Pre</a>
        </c:if>
	<c:forEach begin="1" end="${tp}" var="i">
		<c:choose>
			<c:when test="${cp==i}">
				<c:out value="${i}"></c:out>
			</c:when>
			<c:otherwise>
				<a href="viewUsers?page=${i}" style="color: blue;background-color: white; height: 20px; width: 60px;">${i}</a>

			</c:otherwise>
		</c:choose>
	</c:forEach>
     <c:if test="${cp<tp}">
            <a href="viewUsers?page=${cp+1}"  style="color: blue;background-color: white; height: 20px; width: 60px;">Next</a>
        </c:if>
        
        
        </div>
</body>
</html>