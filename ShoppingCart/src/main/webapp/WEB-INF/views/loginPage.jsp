<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html >
<html>
<head>


<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Login</title>
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include> 
 <div class="container">
 <div class="row">
 <div class="col-sm-6 item-photo">
<img src="${pageContext.request.contextPath}/resources/img/Login.png">
</div>
    
   <br><br>
   <h3>Welcome Back</h3>
     
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                 Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
       
   <h3>Enter user name and password:</h3>  
     
 
<form:form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" >
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value='' required></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' required/></td>
         </tr>
         
         <tr>
         <br><br>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form:form>
  
  <p>Not a user? <a href="${pageContext.request.contextPath}/register">Register now</a>
  
  </p>
  </div>
  </div>
  
</body>

</html>