<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true">

	</tiles:insertAttribute></title>
</head>
<body>
	<table width="100%">

		<tr height="70px">
			<td width="100%"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr height="600px">
			<td width="100%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr height="80px">
			<td width="100%"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>