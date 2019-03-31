<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant Registration</title>
</head>
<body bgcolor="lightYellow">
	<form:form modelAttribute="merchantForm">
		<table align="center">
			<tr>
				<td colspan="2"><form:errors path="*" /></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>primary Contact No :</td>
				<td><form:input path="pContactNo" /></td>
			</tr>
			<tr>
				<td>Alternate Contact No :</td>
				<td><form:input path="aContactNo" /></td>
			</tr>
			<tr>
				<td>primary Email Address :</td>
				<td><form:input path="pEmailAddress" /></td>
			</tr>
			<tr>
				<td>alternate Email Address :</td>
				<td><form:input path="aEmailAddress" /></td>
			</tr>
			<tr>
				<td>description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Primary Address :</td>
			</tr>
			<tr>
				<td colspan="2">
					<table>
						<tr>
							<td>Address Line1 :</td>
							<td><form:input path="pAddressLine1" /></td>
						</tr>
						<tr>
							<td>Address Line2 :</td>
							<td><form:input path="pAddressLine2" /></td>
						</tr>
						<tr>
							<td>City :</td>
							<td><form:input path="pCity" /></td>
						</tr>
						<tr>
							<td>State :</td>
							<td><form:input path="pState" /></td>
						</tr>
						<tr>
							<td>Pin :</td>
							<td><form:input path="pPin" /></td>
						</tr>
						<tr>
							<td>Country :</td>
							<td><form:input path="pCountry" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>Secondary Address :</td>
			</tr>
			<tr>
				<td colspan="2">
					<table>
						<tr>
							<td>Address Line1 :</td>
							<td><form:input path="sAddressLine1" /></td>
						</tr>
						<tr>
							<td>Address Line2 :</td>
							<td><form:input path="sAddressLine2" /></td>
						</tr>
						<tr>
							<td>City :</td>
							<td><form:input path="sCity" /></td>
						</tr>
						<tr>
							<td>State :</td>
							<td><form:input path="sState" /></td>
						</tr>
						<tr>
							<td>Pin :</td>
							<td><form:input path="sPin" /></td>
						</tr>
						<tr>
							<td>Country :</td>
							<td><form:input path="sCountry" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Merchant Logo :</td>
				<td><input type="file" name="merchantLogo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>