<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
Shopping Cart!
<br>
<br>
<a href="usersform">Add User</a>  
<a href="viewusers">View Users</a>  
<a href="categoriesform">Add Categories</a>
<a href="viewcategories">View Categories</a>
<a href="addproducts">Add Products</a>
<a href="viewproducts">View Products</a>

</body>
</html>