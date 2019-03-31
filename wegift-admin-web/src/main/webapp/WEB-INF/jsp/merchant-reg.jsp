<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<head>
<link rel="stylesheet" type="text/css" href="css/contact.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<div class="reg-font" align="center">
	<form:form modelAttribute="merchant" enctype="multipart/form-data">
		<h1 align="center" style="font-family: arial">Merchant
			Registration Form</h1>
		<table style="position: center;">
			<tr>
				<td><spring:message code="reg.firstName" /><span style="color: red">*</span> :
				</td>
				<td><form:input path="firstName" placeholder="Enter firstName" cssClass="form-control" /></td>
				<td id="firstName_error" class="errors"><form:errors
						path="firstName" /></td>
			</tr>
			<tr>
				<td><spring:message code="reg.lastName"/><span style="color: red">*</span> :
				</td>
				<td colspan="1"><form:input path="lastName"
						placeholder="Enter LastName" cssClass="form-control"  /></td>
				<td id="lastName_error" class="errors"><form:errors
						path="lastName" /></td>
			</tr>
			<tr>
				<td>primary Contact No <span style="color: red">*</span> :
				</td>
				<td><form:input path="primaryContactNo"
						placeholder="enter mobileno" cssClass="form-control" /></td>
				<td class="errors" id="primaryContactNo_error"><form:errors
						path="primaryContactNo" /></td>
			</tr>
			<tr>
				<td>Alternate Contact No :</td>
				<td><form:input path="alternateContactNo"
						placeholder="9098909090" cssClass="form-control" /></td>
				<td class="errors" id="alternateContactNo_error"><form:errors
						path="alternateContactNo" /></td>
			</tr>
			<tr>
				<td>primary Email Address <span style="color: red">*</span> :
				</td>
				<td><form:input path="primaryEmailAddress"
						placeholder="please enter email id" onchange="checkmail();" cssClass="form-control"  /></td>
				<td class="errors" id="primaryEmailAddress_error"><form:errors
						path="primaryEmailAddress" /></td>
			</tr>
			<tr>
				<td>alternate Email Address :</td>
				<td><form:input path="alternateEmailAddress"
						placeholder="alternate email id" cssClass="form-control" /></td>
				<td class="errors" id="alternateEmailAddress_error"><form:errors
						path="alternateEmailAddress" /></td>
			</tr>
			<tr>
				<td colspan="3"><hr /></td>
			</tr>
			<tr>
				<th class="heading">ADDRESS INFORMATION</th>
			</tr>
			<tr>
				<td colspan="3"><hr /></td>
			</tr>
			<tr>
				<td>Address Line1 <span style="color: red">*</span> :
				</td>
				<td><form:textarea cols="20" rows="5" path="addressLine1"
						placeholder="enter address" cssClass="textarea" /></td>
				<td class="errors" id="addressLine1_error"><br /> <form:errors
						path="addressLine1" /></td>
			</tr>
			<tr>
				<td>Address Line2 :</td>
				<td><form:textarea cols="20" rows="5" path="addressLine2" cssClass="textarea" /></td>
				<td class="errors" id="addressLine2_error" ><form:errors
						path="addressLine2" /></td>
			</tr>
			<tr>
				<td>City <span style="color: red">*</span> :
				</td>
				<td><select name="city" class="select">
						<c:forEach items="${cities}" var="city">
							<option selected="selected" value="${city}">${city}</option>
						</c:forEach>
				</select></td>
				<td class="errors" id="city_error"><form:errors path="city" /></td>
			</tr>
			<tr>
				<td>State <span style="color: red">*</span> :
				</td>
				<td><select name="state" class="select">
						<c:forEach items="${states}" var="state">
							<option class="form-control" value="${state}">${state}</option>
						</c:forEach>
				</select></td>
				<td class="errors" id="state_error"><form:errors path="state" /></td>
			</tr>
			<tr>
				<td>Pin <span style="color: red">*</span> :
				</td>
				<td><form:input path="zip" placeholder="enter pin ex :500090" cssClass="form-control" /></td>
				<td class="errors" id="zip_error"><form:errors path="zip" /></td>
			</tr>
			<tr>
				<td>Country <span style="color: red">*</span> :
				</td>
				<td><form:input path="country" placeholder="enter country ex: INDIA" cssClass="form-control"/></td>
				<td class="errors" id="country_error"><form:errors
						path="country" /></td>
			</tr>

			<tr>
				<td>Merchant Logo <span style="color: red">*</span> :
				</td>
				<td><input type="file" name="merchantLogo" class="file"/></td>
				<td class="errors" id="merchantLogo_error"><form:errors
						path="merchantLogo" /></td>
			</tr>
			<tr>
				<td>Description <span style="color: red">*</span> :
				</td>
				<td><form:textarea cols="30" rows="5" path="description"
						placeholder="enter description" cssClass="textarea"/></td>
				<td class="errors" id="description_error"><form:errors
						path="description" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="REGISTER" onclick="validate();" class="button"/></td>
			</tr>
		</table>

	</form:form>
	<script type="text/javascript">
		function checkmail() {
			var email = document.getElementById("primaryEmailAddress").value;

			var url = "http://localhost:8081/wegift-admin-web/checkMail.htm?primaryEmailAddress="
					+ email;

			var http = new XMLHttpRequest();
			http.onreadystatechange = function() {
				if (http.readyState == 4 && http.status == 200) {

					var text = http.responseText;
					document.getElementById("primaryEmailAddress_error").innerHTML = text;

				}
			};
			http.open("GET", url, true);
			http.send(url);
		}

		function validate() {
			var inputFeilds = document.querySelectorAll("input[type='text']");

			for (var i = 0; i < inputFeilds.length; i++) {
				if (inputFeilds[i].value == ""
						&& inputFeilds[i].value.trim.length <= 0) {
					document.getElementById(inputFeilds[i].name + "_error").innerHTML = "please enter "
					inputFeilds[i].name;
				}
			}

			var textAreaFeilds = document.querySelectorAll("textarea");

			for (var i = 0; i < textAreaFeilds.length; i++) {
				if (textAreaFeilds[i].value == ""
						&& textAreaFeilds[i].value.trim.length <= 0) {
					document.getElementById(textAreaFeilds[i].name + "_error").innerHTML = "please provide the "
							+ textAreaFeilds[i].name;
				}
			}

			var selectControls = document.querySelectorAll("select");

			for (var i = 0; i < selectControls.length; i++) {
				if (selectControls[i].selected == false) {
					document.getElementById(selectControls[i].name + "_error").innerHTML = "please select "
							+ selectControls[i].name;
				}
			}
		}
	</script>
</div>
