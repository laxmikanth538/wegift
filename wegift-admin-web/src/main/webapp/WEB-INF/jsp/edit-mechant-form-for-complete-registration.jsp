<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant Complete Registration</title>
</head>
<body bgcolor="lightyellow">
	<form:form modelAttribute="editMerchant">

		<table align="center">
			<tr>
				<td style="color: red; size: 14px"><form:errors path="*" /></td>
			</tr>
			<tr>
				<td><form:hidden path="onlineUserId" /></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><form:input path="username" cssClass="text_input" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" cssClass="password_input" /></td>
			</tr>
			<tr>
				<td>ReEnter Password :</td>
				<td><form:password path="rePassword" cssClass="password_input" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="UPDATE" class="btn_input" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>