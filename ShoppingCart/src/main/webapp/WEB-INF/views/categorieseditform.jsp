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
 <form:form method="POST" action="/ShoppingCart/editsavecategories">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="categoryId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="categoryName"  /></td>  
         </tr>    
         <tr>    
          <td>Description :</td>    
          <td><form:input path="categoryDescription" /></td>  
         </tr>
         <tr>   
          <td><input type="submit" value="Edit Save" /></td> 
          <td><input type="reset" value="cancel" /></td>   
         </tr>    
        </table>    
       </form:form>    
</body>
</html>