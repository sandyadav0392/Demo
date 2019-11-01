<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
.error {
	color: white
	}
	
	.ui-datepicker {
   background: #333;
   border: 1px solid #555;
   color: #EEE;
}
</style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
 <script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				username : 'required',
			   password: {
			        required: true,
			        minlength: 8
			      },
				email : {
					required : true,
					email : true
				},
				phone : {
			        required: true,
			        minlength: 10,
			        maxlength: 10
			       
			      },
			      dob :{
				        required: true,
				 },
				 countries : 'required'
			},
			messages : {
				username : 'Please enter username',
				password :{
					required : 'please enter password',
					minlength : 'please enter mininum 8 character'
				},
				email : {
					required :'Please enter valid email',
					email : 'please enter correct email'
				},
				phone : {
					required :'Please enter valid phone',
					minlength : 'please enter minimum 10 digit only',
					maxlength : 'please enter maximum 10 digit only'
				},
				dob : {
					required :'Please enter valid DoB',
				},
				countries : 'Please enter Cournties'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
<script>
//for  datepicker format
$( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
</script>
 <style>
  body {
          background-image: url('images/test7.jpg');
           color: white;
  }
 </style>
 </head>
<body>
                     <%@include file="header.jsp" %>
            
         <p>
            <b style="color:white;">${msg}</b>
         </p>
     
        <form:form id="userRegForm" action="updateUser?userId=${user.userid}" modelAttribute="user" method="POST">
           <table style="color:white; background-color: black; opacity: 0.7; width: 500px;height: 166px;">
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>Date of Birth</td> -->
<%-- 				<td><form:input path="dob" id="datepicker"/></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Select your Country</td>
				<td><form:select path="countries" items="${cnt}"></form:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
        </form:form>
        <br>
       <button>  <a href="registerForm">+Add User  &nbsp; &nbsp;</a></button><button> <a href="viewUsers?page=1">View All Users</a></button>
</body>
</html>