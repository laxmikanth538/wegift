<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant HOME</title>

</head>

<body>
	<%-- <ul class="snip1226">
		<li class="current"><a href="#" data-hover="Home">Home</a></li>
		<li><a href="#" data-hover="About Us">About Us</a></li>
		<li><a href="#" data-hover="Member Card Register">Member Card
				Register</a></li>
		<li><a href="#" data-hover="Services">Services</a></li>
		<li><a href="#" data-hover="Contact">Contact</a></li>
		<li><a href="${pageContext.request.contextPath}/perform_logout"
			data-hover="Logout">Logout</a></li>
	</ul>
 --%>
	<div>
		<div>
			<h2>Hello ${pageContext.request.userPrincipal.name} You are
				Logged in sucessfully</h2>

		</div>

		<!-- <ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
 -->
	</div>



</body>
</html>
