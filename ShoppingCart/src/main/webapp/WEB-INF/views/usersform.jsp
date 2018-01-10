<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>

        <h1>Add New Users</h1>  
       <form:form method="post" action="save">    
        <table > 
        <tr>    
          <td>Id : </td>   
          <td><form:input path="userId"  /></td>  
         </tr>       
         <tr>    
          <td>Name : </td>   
          <td><form:input path="userName"  /></td>  
         </tr>    
         <tr>    
          <td>Address :</td>    
          <td><form:input path="userAddress" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="userEmail" /></td>  
         </tr>  
          
          <tr>
          <td>Phone No :</td>    
          <td><form:input path="userPhone" /></td>  
         </tr> 
          <tr>
          <td>Enabled :</td>    
          <td><form:checkbox path="enabled" /></td> 
          
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>  
            
        </table>    
       </form:form>    

</body>
</html>
