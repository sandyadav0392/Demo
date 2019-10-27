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
 <!-- <script type="text/javascript">
 function validateForm() {
	  var x = document.forms["reg"]["user"].value;
	  if (x == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	  var a = document.forms["reg"]["pass"].value;
	  if (a == "") {
	    alert("Password must be filled out");
	    return false;
	  }
	  var b = document.forms["reg"]["mail"].value;
	  if (b == "") {
	    alert("E-mail must be filled out");
	    return false;
	  }
	  var c = document.forms["reg"]["phone"].value;
	  if (c == "") {
	    alert("Phone number must be filled out");
	    return false;
	  }
	}
 </script> -->
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
     
        <form:form id="userRegForm" action="registerForm" modelAttribute="user" method="POST">
           <table style="color:white; background-color: black; opacity: 0.7; width: 500px;height: 166px;">
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
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
        <br><br>
        <a href="viewUsers?page=1" style="color:white; font-size: 22px;">View All Users</a>
        <hr>
        <p>If you already Register then login direct.</p>
        <br>
          <h3 style="text-align: center;">User Login</h3>
          <p>
           <center> <b style="color:green;">${msg1}</b></center>
         </p>
       <center><table>
        <form:form action="home" modelAttribute="user" method="POST">
           <tr>
            <td>E-mail</td>
            <td><form:input  path="email" id="mail"/></td>
           </tr>
           <tr> 
            <td>Password</td>
            <td><form:password path="password" id="pass"/></td>
           </tr>
           <tr>
              <td colspan="1"></td>
            <td colspan="1"><input type="submit" value="Login"></td>
           </tr>
        </form:form>
       </table></center>
       <hr>
</body>
</html>