  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 <c:set var="context" value="${pageContext.request.contextPath}"/>
 


  
 
  
 
<nav class="navbar navbar-light"style="background-color: brown;">
<div class="container fluid">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navDemo">
<span class="icon-bar"style="background-color: black;"></span>
<span class="icon-bar"style="background-color: black;"></span>
<span class="icon-bar"style="background-color: black;"></span>
</button>
<ul class="nav navbar-nav navbar-left">
  <a class="navbar-brand brand-name" href="#"><i class="fa fa-cart-plus" aria-hidden="true"style="font-size:25px;color:black;position:absolute; top:0; left:0;">&nbsp;<i>Shopping Cart</i></i></a>
</ul>  
  </div> 
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <br>
           <!-- each <li> </li> is one menu option -->
   <li><a href="${pageContext.request.contextPath}/index"><i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a></li>
   <li><a href="${pageContext.request.contextPath}/home1"><i class="fa fa-book" aria-hidden="true"></i>Home1</a></li>
        <li><a href="${pageContext.request.contextPath}/contact"><i class="fa fa-address-book" aria-hidden="true"></i>Contact</a></li>
       
               
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
     
      
<c:if test="${pageContext.request.userPrincipal.name==null}"><li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-user"></span> Sign UP</a></li></c:if>
        
      </ul>
       <ul class="nav navbar-nav">

<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="${context}/viewproducts">Admin Control</a></li>
<li><a href="${context}/categoriesform">Add Category</a></li>
<li><a href="${context}/viewcategories">View Categories</a></li>
<li><a href="${context}/addproduct">Add Product</a></li>


</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
<li><a href="${pageContext.request.contextPath}/cartview">Cart</a></li>
</security:authorize>
 </ul>  
      </div>
  </div>
</nav>
 