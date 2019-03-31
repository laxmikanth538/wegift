<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body bgcolor="lightyellow">
	<form
		action="${pageContext.request.contextPath}/j_spring_security_check"
		method="post">

		<%-- <c:if test="${error eq badCredentails}">
			<p style="color: red; font-size: 14">credentials are invalid</p>
		</c:if>

 --%>
		<%
			if (request.getParameter("error") != null) {
		%>
		<p align="center" style="color: red; font-size: 14">Sorry Seems
			like Your credentials are Invalid</p>
		<%
			}
		%>

		<table align="center">
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="j_username" class="text_input"/></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="j_password" class="text_input"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login" class="btn_input"></td>
			</tr>
		</table>
	</form>
</body>
</html>