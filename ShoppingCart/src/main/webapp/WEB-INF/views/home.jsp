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
   <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
   </head>


<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<h2>Shopping Cart!</h2>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${pageContext.request.contextPath}\resources\img\mobile.jpg" alt="Image"style="width:100%;">
        <div class="carousel-caption">
          <h3>New Mobiles</h3>
          <p>This week's top stories...</p>
        </div>      
      </div>

      <div class="item">
        <img src="${pageContext.request.contextPath}\resources\img\fashion.jpg" alt="Image"style="width:100%;">
        <div class="carousel-caption">
          <h3>New fashion clothes</h3>
          <p>This week's top stories...</p>
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
      


  
   <footer class="container-fluid text-center">
  <p>100% Purchase Protection</p>
</footer>
  




  

</body>
</html>>