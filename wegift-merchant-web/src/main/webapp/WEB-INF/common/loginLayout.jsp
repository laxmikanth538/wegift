<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="<c:url value="/resources/css/styleformHome.css" />">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true">

	</tiles:insertAttribute></title>
</head>
<body>
	<ul class="snip1226">
		<li class="current"><a href="#" data-hover="Home">Home</a></li>
		<li><a href="#" data-hover="About Us">About Us</a></li>
		<li><a href="#" data-hover="Member Card Register">Member Card
				Register</a></li>
		<li><a href="#" data-hover="Services">Services</a></li>
		<li><a href="#" data-hover="Contact">Contact</a></li>
		<li><a href="${pageContext.request.contextPath}/perform_logout"
			data-hover="Logout">Logout</a></li>
	</ul>
	<table width="100%">

		<tr height="600px">
			<td width="100%"><tiles:insertAttribute name="body" /></td>
		</tr>
	</table>
</body>
</html>