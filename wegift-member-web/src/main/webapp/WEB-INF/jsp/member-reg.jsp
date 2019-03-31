<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Registration</title>
</head>
<div>
	<form:form modelAttribute="member">
		<h4 align="center" style="color: navy;">Register your self
			Directly with We-Gift</h4>
		<table align="center">
			<tr>
				<td>First Name :<span style="color: red;">*</span></td>
				<td><form:input path="firstName" placeholder="Your good name ?"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName :<span style="color: red;">*</span></td>
				<td><form:input path="lastName" placeholder="Last name ?"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Gender :<span style="color: red;">*</span></td>
				<td><input type="radio" name="gender" value="m" checked>Male
					<input type="radio" name="gender" value="f">Female</td>

			</tr>
			<tr>
				<td>DOB :<span style="color: red;">*</span></td>
				<td><form:input path="dob" placeholder="DD/MM/YYYY"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="dob" /></td>
			</tr>
			<tr>
				<td>Contact Mobile :<span style="color: red;">*</span></td>
				<td><form:input path="mobile" placeholder="9999999999"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="mobile" /></td>
			</tr>
			<tr>
				<td>email Address :<span style="color: red;">*</span></td>
				<td><form:input path="email" placeholder="yourName@gmail.com"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Address Line1 :<span style="color: red;">*</span></td>
				<td><form:textarea rows="2" path="addressLine1"
						placeholder="HDr.No.1/1/123, street name, Landmark"
						cssClass="textarea" /></td>
				<td class="errors"><form:errors path="addressLine1" /></td>
			</tr>
			<tr>
				<td>Address Line2 :</td>
				<td><form:textarea rows="2" path="addressLine2"
						placeholder="landmark -2, town name " cssClass="textarea" /></td>
				<td class="errors"><form:errors path="addressLine2" /></td>
			</tr>

			<tr>
				<td>City :<span style="color: red;">*</span></td>
				<td><select name="city" class="select">
						<c:forEach items="${cities}" var="city">
							<option selected="selected" value="${city}">${city}</option>
						</c:forEach>
				</select></td>
				<td class="errors"><form:errors path="city" /></td>
			</tr>
			<tr>
				<td>State :<span style="color: red;">*</span></td>
				<td><select name="state" class="select"><c:forEach
							items="${states}" var="state">
							<option value="${state}">${state}</option>
						</c:forEach></select></td>
				<td class="errors"><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td>Zip :<span style="color: red;">*</span></td>
				<td><form:input path="zip" placeholder="zip"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="zip" /></td>
			</tr>
			<tr>
				<td>Country :<span style="color: red;">*</span></td>
				<td><form:input path="country" placeholder="country"
						cssClass="text_input" /></td>
				<td class="errors"><form:errors path="lastName" /></td>
			</tr>
			<tr align="center">
				<td colspan="2" align="center" class="button:hover"><input
					type="submit" value="REGISTER" class="btn_input" />
			</tr>
		</table>
	</form:form>
</div>