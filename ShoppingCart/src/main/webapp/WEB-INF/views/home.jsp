<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
   <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <style>
   
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    body{
    background-color: coral;
    }
    
    .carousel-indicators .active{
    background-color: #f00;
}
  
    
    
  .carousel-inner img {
      
      width: 100%; 
      margin: auto;
      min-height:200px;
        object-fit: contain;

  
  }
 
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
    }
    footer {
    clear: both;
    position: relative;
    z-index: 10;
    height: 3em;
    margin-top: -3em;
}
  
  </style>
   </head>


<body>
<%@  include file="header.jsp" %>



 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/resources/img/mobile.jpg" alt="Image">
       
        <div class="carousel-caption">
          <h3 style="color:blue;">New Mobiles</h3>
          <p style="color:blue;">This week's top stories...</p>
        </div>      
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/img/fashion.jpg" alt="Image">
         
        <div class="carousel-caption">
          <h3 style="color:blue;">New fashion clothes</h3>
          <p style="color:blue;">This week's top stories...</p>
        </div>      
      </div>
      <div class="item">
        <img src="${pageContext.request.contextPath}/resources/img/books2.jpg" alt="Image">
        <br><br><br>
        <div class="carousel-caption">
          <h3 style="color:blue;">New Books</h3>
          <p style="color:blue;">This week's top stories...</p>
        </div>      
      </div>
    </div>
    
    
    

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
      
<br><br>

  <footer >
  <nav class="navbar navbar-light"style="background-color: pink;">
<div class="container">

    <div class="collapse navbar-collapse" id= "navDemo">

                <ul class="nav navbar-nav navbar-right">
                 <div class="icons">
                    <!--Facebook-->
                    <a href="https://www.facebook.com/"><i class="fa fa-facebook-official" style="font-size:24px"></i></a>
                    <!--Twitter-->
                    <a href="https://www.twitter.com/"><i class="fa fa-twitter" style="font-size:24px"></i></a>
                    <!--Google +-->
                    <a href="https://www.plus.google.com/"><i class="fa fa-google-plus" style="font-size:24px"></i></a>
                    <!--Linkedin-->
                    <a href="https://www.linkedin.com/"><i class="fa fa-linkedin" style="font-size:24px"></i></a>
                    <!--Instagram-->
                    <a href="https://www.instagram.com/"><i class="fa fa-instagram" style="font-size:24px"></i></a>
       </div>
       </ul>
        </div>
       <div class="footer-bottom">
        <div class="container">
            <p class="pull-left"> Copyright © Bloom. All right reserved. </p>
        </div>
    </div>
            </div>
            </nav>
</footer>
  


  

</body>
</html>>