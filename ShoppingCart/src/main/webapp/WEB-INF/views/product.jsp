<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    
    
<!DOCTYPE html>
<html>
<head>
  <title>product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>

<body>
<jsp:include page="header.jsp"></jsp:include> 

 <div class="container">
 <div class="row">
 <div class="col-sm-6 item-photo">
<img style="max-width:100%; margin-top:30 px;" src="${pageContext.request.contextPath}/${product.productImage}">
</div>
<div class="col-md-6" style="border:0px solid gray">

              <h2><label>${product.productName}</label></h2>
              <h3>${product.price}</h3>
              <h4>${product.productcategories.categoryName}</h4> <br> 




   <br><br>
     <a href="${pageContext.request.contextPath}/addToCart/${product.productId}" class="btn btn-info btn-lg">
     <span class="glyphicon glyphicon-shopping-cart"></span>addToCart</a>
     
     </div>
     </div>
     </div>
     
     <div class="col-xs-9">
     <ul class="menu-items">
     <br><li>100% Original Product...</li>
     </ul>
     </div>
     
</body>
</html>