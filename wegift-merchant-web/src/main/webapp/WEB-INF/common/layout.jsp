<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style1.css">
<link rel="stylesheet" type="text/css" href="resources/css/contact.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body bgcolor="lightyellow">
	<table width="100%">
		<tr height="60px">
			<td width="100%"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr height="80px">
			<td width="100%">
				<ul>
					<li class="li-left"><a href="#"><button type="button"
								class="active">Home</button></a></li>
					<li><a href="#"><button type="button">Profile</button></a></li>
					<li class="dropdown"><a href="#" class="dropbtn"><button
								type="button">Register</button></a>
						<div class="dropdown-content">
							<a href="#">Member Card Register</a>
						</div></li>
					<li><a href="#"><button type="button">Services</button></a></li>
					<li><a href="#"><button type="button">Contact</button></a></li>
					<li><a
						href="${pageContext.request.contextPath}/perform_logout"
						style="float: right"><button type="button">Logout</button></a></li>
				</ul>
			</td>
		</tr>
		<tr height="500px">
			<td width="100%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr height="80px">
			<td width="100%"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>