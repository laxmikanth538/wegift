<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true">

	</tiles:insertAttribute></title>
</head>
<body bgcolor="lightyellow">
	<table width="100%">

		<tr height="70px">
			<td width="100%"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr height="80px">
			<td width="100%">
				<ul>
					<li class="li-left"><a href="./home.htm"><button
								type="button" class="active button">HOME</button></a></li>
					<li><a href="${pageContext.request.contextPath}/member-reg.htm"><button type="button" class="button">MERCHANTS</button></a></li>
					<li><a href="#"><button type="button" class="button">PRODUCTS</button></a></li>
					<li><a href="#"><button type="button" class="button">ABOUT
								US</button></a></li>
					<li><a
						href="${pageContext.request.contextPath}/contact-us.htm"><button
								type="button" class="button">CONTACT US</button></a></li>
					<li><c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">
								<a href="${pageContext.request.contextPath}/logout"><button
										type="button" class="button">LOGOUT</button></a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/login.htm"><button
										type="button" class="button">Login</button></a>
							</c:otherwise>
						</c:choose></li>
				</ul>
			</td>
		</tr>
		<tr height="520px">
			<td width="80%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr height="80px">
			<td width="100%"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>