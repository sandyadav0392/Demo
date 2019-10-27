<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    /* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
    body{        
      padding-top: 0px; 
        padding-bottom: 40px;
    }
    .fixed-header, .fixed-footer{
        width: 100%;       
        background: #333;
        padding: 10px 0;
        color: #fff;
        font-family: cursive;
        font-size: 20px;
    }
    .fixed-header{
        top: 0;
    }
    .fixed-footer{
        bottom: 0;
    }
    .container{
        width: 80%;
        margin: 0 auto; /* Center the DIV horizontally */
    }
    nav a{
        color: #fff;
        text-decoration: none;
        text-shadow :5px;
        padding: 7px 25px;
        display: inline-block;
        font-size: 20px;
    }
</style>
</head>
<body>
  <h1 style="color:white; background: black;height: 80px;text-align:left;"><img src="images/new1.gif" height="70px" width="150px"><i>Coffee Preview</i> </h1>  
  
            <div class="fixed-header">
        <div class="container">
            <nav>
                <a href="#">Home</a>
                <a href="#">About</a>
                <a href="#">Products</a>
                <a href="#">Services</a>
                <a href="#">Contact Us</a>
            </nav>
        </div>
    </div> 
</body>
</html>