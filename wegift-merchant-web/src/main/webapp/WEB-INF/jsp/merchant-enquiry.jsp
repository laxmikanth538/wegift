<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<title>Merchant Enquiry</title>
<div >
	<h2 align="center" style="font-family: arial">Merchant Enquiry</h2>
	<form:form modelAttribute="enquiryForm">
		<table align="center">
			<tr>
				<td>OrganizationName <span style="color: red;">*</span> :
				</td>
				<td><form:input path="orgName" placeholder="your Org name" /></td>
				<td  class="errors"><form:errors path="orgName" /></td>
			</tr>
			<tr>
				<td>Business Type <span style="color: red;">*</span> :
				</td>
				<td><form:input path="businessType"
						placeholder="your Business type" /></td>
				<td class="errors"><form:errors path="businessType" /></td>
			</tr>
			<tr>
				<td>Year Of Established <span style="color: red;">*</span> :
				</td>
				<td><form:input path="yearOfEstd" placeholder="Org Estd year" /></td>
				<td class="errors"><form:errors path="yearOfEstd" /></td>
			</tr>
			<tr>
				<td>Location <span style="color: red;">*</span> :
				</td>
				<td><form:input path="merchantLocation" placeholder="Location" /></td>
				<td class="errors"><form:errors path="merchantLocation" /></td>
			</tr>
			<tr>
				<td>Contact Person <span style="color: red;">*</span> :
				</td>
				<td><form:input path="contactPerson"
						placeholder="Person to whom we call" /></td>
				<td class="errors"><form:errors path="contactPerson" /></td>
			</tr>
			<tr>
				<td>Contact No. <span style="color: red;">*</span> :
				</td>
				<td><form:input path="contactNo"
						placeholder="Working Contact No" /></td>
				<td class="errors"><form:errors path="contactNo" /></td>
			</tr>
			<tr>
				<td>Contact Email <span style="color: red;">*</span> :
				</td>
				<td><form:input path="contactEmail" placeholder="Contact Email" /></td>
				<td class="errors"><form:errors path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input path="description"
						placeholder="description(optional)" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enquire" /></td>
			</tr>
			<%-- <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> --%>
		</table>
	</form:form>
</div>