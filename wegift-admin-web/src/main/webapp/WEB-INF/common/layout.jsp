<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<link rel="stylesheet" type="text/css" href="contact.css">
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
					<li><a href="./home.htm" class="active">HOME</a></li>
					<li class="dropdown"><a class="dropbtn" href="#">ENQUIRIES</a>
						<div class="dropdown-content">
							<a
								href="${pageContext.request.contextPath}/enquiries.htm?status=p&pageNo=0">PENDINGS</a>
							<a href="${pageContext.request.contextPath}/enquiries.htm?status=a&pageNo=0">APPROVED</a><a
								href="${pageContext.request.contextPath}/enquiries.htm?status=r&pageNo=0">REJECTED
							</a>
						</div></li>
					<li><a href="#">MERCHANTS</a></li>
					<li class="dropdown"><a href="#" class="dropbtn">REPORTS</a>
						<div class="dropdown-content">
							<a href="#">DAILY REPORTS</a> <a href="#">MONTHLY REPORTS</a><a
								href="#">ANNUAL REPORTS</a>
						</div></li>
					<li><a href="#">MEMBERS</a></li>
					<li><a href="#">PRODUCTS MAINTAINANCE</a></li>
					<li><a href="./contact-us.htm">CONTACT US</a></li>
					<li><a href="./merchant-reg.htm">REGISTRATIONS</a></li>
					<li><a href="./logout">LOGOUT</a></li>
				</ul>
			</td>
		</tr>
		<tr height="600px">
			<td width="80%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr height="80px">
			<td width="100%"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>