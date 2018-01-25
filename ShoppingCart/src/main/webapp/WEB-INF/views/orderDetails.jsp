<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html >




<html>
<body>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>Order Details</title>

</head>
<body>

<div class="container">
 <div class="row">
 <div class="col-sm-6 item-photo">
<img style="max-width:40%; margin-top:30 px;" src="${pageContext.request.contextPath}/resources/img/customer_ details.jpg">
</div>

<form>

<th><h2>Customer Details</h2></th><br>
<table>
<h4>Total: ${orders.orderTotal}</h4>
<h4>Name : ${orders.users.userName }</h4>
<h4>Address: ${orders.orderAddress }</h4>
<h4>PIN: ${orders.orderPin }</h4>
<h4>Date: ${orders.orders }</h4>

</table>
</div>
</div>
<div class="container">
                                           
  <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Payment<span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="${pageContext.request.contextPath}/checkout">COD</a></li>
      <li><a href="${pageContext.request.contextPath}/payment">Net Banking</a></li>
      
    </ul>
  </div>
</div>

</form>


</body>
</html>