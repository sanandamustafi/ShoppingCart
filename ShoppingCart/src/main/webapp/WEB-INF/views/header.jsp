  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 <c:set var="context" value="${pageContext.request.contextPath}"/>
 


  
 
  
 
<nav class="navbar navbar-inverse">
<div class="container fluid">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navDemo">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>

  <a class="navbar-brand" href="#"><i class="fas fa-shopping-cart"></i>Shopping Cart</a>  
  </div> 
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
           <!-- each <li> </li> is one menu option -->
   <li><a href="${pageContext.request.contextPath}/index"><i class="fa fa-home fa-fw" aria-hidden="true"></i>&nbsp;Home</a></li>
        <li><a href="contact"><i class="fa fa-address-book" aria-hidden="true"></i>&nbsp;Contact</a></li>
 <li><a href="usersform">Add User</a></li>  
<li><a href="viewusers">View Users</a></li>  
<li><a href="categoriesform">Add Category</a></li>
<li><a href="viewcategories">View Categories</a></li>
<li><a href="addproduct">Add Product</a></li>
<li><a href="viewproducts">View Products</a></li>
               
        <!-- <li class="dropdown"> is used to create a menu option which will have sub menu -->
        <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
          <!-- display category names as menu option  -->
           <c:forEach items="${categoryList}" var="categories">
            <li><a href="${pageContext.request.contextPath}/showproductsbycategory/${categories.categoryId}">${categories.categoryName}</a></li>
             </c:forEach>
          </ul>
          
          </li>
          <security:authorize access="hasRole('ROLE_ADMIN')"><li></li></security:authorize>
          </ul>
          
 
<ul class="nav navbar-nav navbar-right">
        
        
<c:if test="${pageContext.request.userPrincipal.name == null}"><li><a href="${pageContext.request.contextPath}/loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}"><li><a href="">Hello ${pageContext.request.userPrincipal.name}</a></li></c:if>
<c:if test="${pageContext.request.userPrincipal.name != null}"> <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li></c:if>
     
      
<c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-register"></span> Sign UP</a></li></c:if>
        
      </ul>
       <ul class="nav navbar-nav">

<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="${context}/viewproducts">Admin Control</a></li>
</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
<li><a href="${pageContext.request.contextPath}/cartview">Cart</a></li>
</security:authorize>
 </ul>  
      </div>
  </div>
</nav>
 