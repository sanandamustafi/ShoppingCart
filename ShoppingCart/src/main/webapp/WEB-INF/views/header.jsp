<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html> 
 <title>Header</title>
 <head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
   </head>
  
  <c:set var="context" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-inverse">
<div class="container fluid">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navDemo">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>

  <a class="navbar-brand" href="#"><i class="fas fa-shopping-cart"></i>Shopping Cart</a>  
  </div> 
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
           <!-- each <li> </li> is one menu option -->
        <li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
        <!-- <li class="dropdown"> is used to create a menu option which will have sub menu -->
        <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
          <!-- display category names as menu option  -->
           <c:forEach items="${categoryList}" var="categories">
            <li><a href="${pageContext.request.contextPath}/showproductsbycategory/${categories.categoryId}">${categories.categoryName}</a></li>
             </c:forEach>
          </ul>
          
          </li>
          </ul>
          
 
<ul class="nav navbar-nav navbar-right">
        
        
        <li><a href="${pageContext.request.contextPath}/loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a href="">Hello ${pageContext.request.userPrincipal.name}</a></li>
       <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
     
      
          <li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-register"></span> Sign UP</a></li>
        
      </ul>
   
      </div>
  </div>
</nav>
</body>
</html>