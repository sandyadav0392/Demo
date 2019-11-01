<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    /* Add some padding on document's body to prevent the content
    to go underneath the header and footer */
    body{        
/*        padding-top: 60px; */
        padding-bottom: 40px;
        background-color: white;
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
       <div class="fixed-header">
        <div class="container">
   
    <div class="block wide">
        <strong class="title" role="heading" aria-level="2">Contact Us</strong>
        <ul>
            <li class="phone">+91 (756) 836-8845</li>
            <li><a href="https://www.peets.com/contact-us">Email</a></li>
        </ul>
    </div>
     <div class="block wide">
        <strong class="title" role="heading" aria-level="2">Share</strong>
        <ul class="social-networks">
            <li><a class="instagram" href="http://www.instagram.com/peetscoffee" onclick="return !window.open(this.href)">Instagram</a></li>
            <li><a class="facebook" href="http://www.facebook.com/peets" onclick="return !window.open(this.href)">Facebook</a></li>
            <li><a class="youtube" href="https://www.youtube.com/channel/UChtMUHysfGfTPiWieYJY65g" onclick="return !window.open(this.href)">Youtube</a></li>
            <li><a class="linkedin" href="https://www.linkedin.com/company/peetscoffee/" onclick="return !window.open(this.href)">Linkedin</a></li>
            <li><a class="twitter" href="http://www.twitter.com/PeetsCoffee" onclick="return !window.open(this.href)">Twitter</a></li>
        </ul>
        
       </div>
       <hr>
      <div class="copyright-holder" style="border-bottom-color: black;">
        <address class="copyright">
            <strong>Peet's Coffee</strong> Berkeley, California <span>Since 1966</span>        </address>
        <div class="copyright-links" align="right">
    ®2019 PEET'S COFFEE <span aria-hidden="true" class="sep"> | </span> <a href="https://www.peets.com/privacy-policy">Privacy Policy</a> <span aria-hidden="true" class="sep"> | </span>
    <a href="https://www.peets.com/terms-of-service">Terms of Service</a><br />*Nespresso is a registered trademark of Société des Produits Nestlé S.A., and is not affiliated with Peet’s Coffee Inc. Compatible with most Nespresso Original machines.
</div>

       </div>
    
    </div>
   
    </div>
</body>
</html>