<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <head> 
 <title>Header</title>
   <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
 </head> 
 <body> 
 
<ul class="nav navbar-nav navbar-right">
        
        
        <c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
        <c:if test="${pageContext.request.userPrincipal.name!=null}"><li><a href="">Hello ${pageContext.request.userPrincipal.name}</a></li></c:if>
         <c:if test="${pageContext.request.userPrincipal.name!=null}"><li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li></c:if>
     
      
          <c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-register"></span> Sign UP</a></li></c:if>
        
      </ul>
</body>
</html>