<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<head>
	
<link href="<c:url value="/resources/css/style-pravath.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/index.js" />"></script>
	
</head>
<div class="wrapper">
	<div class="container">
		<h1>Welcome</h1>

		<span style="color: red;"> <%
 	if (request.getParameter("error") != null) {
 		out.print("username or password is not valid");
 	}
 %>
		</span>
		<form
			action="${pageContext.request.contextPath}/j_spring_security_check"
			method="post">
			<input type="text" placeholder="Username" name="j_username">
			<input type="password" placeholder="Password" name="j_password">
			<button type="submit" id="login-button">Login</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>

	<ul class="bg-bubbles">
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
</div>
