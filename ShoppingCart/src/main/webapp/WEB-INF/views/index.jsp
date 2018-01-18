<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Index</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>
<br>
<li><a href="usersform">Add User</a></li>  
<li><a href="viewusers">View Users</a></li>  
<li><a href="categoriesform">Add Category</a></li>
<li><a href="viewcategories">View Categories</a></li>
<li><a href="addproduct">Add Product</a></li>
<li><a href="viewproducts">View Products</a></li>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>