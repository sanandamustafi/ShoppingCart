<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
    
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form:form method="POST" action="/ShoppingCart/editsave">    
        <table >    
        <tr>  
        <td>Id:</td>    
         <td><form:input  path="userId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="userName"  /></td>  
         </tr>    
         <tr>    
          <td>Address  :</td>    
          <td><form:input path="userAddress" /></td>  
         </tr>
         <tr>   
          <td>Email  :</td>    
          <td><form:input path="userEmail" /></td>  
         </tr>
          
         <tr> 
           <td>PhoneNo  :</td>    
          <td><form:input path="userPhone" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>