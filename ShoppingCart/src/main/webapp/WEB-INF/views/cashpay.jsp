<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cash On Delivery</title>

</head>
<body>
<form>

 <li><span class="badge pull-right"><span>&#x20B9; ${grandTotal}</span></span><a> Final Payment</a></li>
 <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-lg btn-block" role="button">Confirm</a>

</form>
</body>
</html>