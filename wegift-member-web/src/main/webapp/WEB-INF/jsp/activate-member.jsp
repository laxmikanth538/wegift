<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link rel="stylesheet" type="text/css" href="style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Activation Page</title>
</head>
<div style="font-size: 18px; color: black">
	<form:form modelAttribute="activateMember">

		<table align="center">
			<tr>
				<td><form:hidden path="onlineUserId" /></td>
			</tr>
			<tr>
				<td>UserName :<span style="color: red">*</span></td>
				<td><form:input path="userName"
						placeholder="Preffered User Name" cssClass="text_input" /></td>
				<td class="errors"><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Password :<span style="color: red">*</span></td>
				<td><form:password path="password" placeholder="Password" cssClass="password_input"/></td>
				<td class="errors"><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>ReEnter Password :<span style="color: red">*</span></td>
				<td><form:password path="rePassword"
						placeholder="Re-Enter password" cssClass="password_input" /></td>
				<td class="errors"><form:errors path="rePassword" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="UPDATE" class="btn_input" /></td>
			</tr>
		</table>
	</form:form>
</div>