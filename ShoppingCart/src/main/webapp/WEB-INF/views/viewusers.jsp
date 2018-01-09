<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html >
<html>
<body>

<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Address</th><th>Email</th><th>PhoneNo</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.userId}</td>  
   <td>${user.userName}</td>  
   <td>${user.userAddress}</td>
   <td>${user.userEmail} </td>
   <td>${user.userPhone}</td>  
  
   <td><a href="editusers/${user.userId}">Edit</a></td>  
   <td><a href="deleteusers/${user.userId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="usersform">Add New User</a>  
</body>
</html>