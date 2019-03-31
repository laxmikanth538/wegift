<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="reg-font">
	<h2 align="center" style="font-family: arial; color: red">${enquiry.organizationName}</h2>
	<table align="center" border="1" cellpadding="5" rules="none">
		<tr>
			<td>Enquiry Id. :</td>
			<td>${enquiry.merchantEnquiryId}</td>
		</tr>
		<tr>
			<td>Organization Name :</td>
			<td>${enquiry.organizationName}</td>
		</tr>
		<tr>
			<td>Business Type :</td>
			<td>${enquiry.businessType}</td>
		</tr>
		<tr>
			<td>Estd Year :</td>
			<td>${enquiry.estdYear}</td>
		</tr>
		<tr>
			<td>Merchant Location :</td>
			<td>${enquiry.merchantLocation}</td>
		</tr>
		<tr>
			<td>Contact Person :</td>
			<td>${enquiry.contactPerson}</td>
		</tr>
		<tr>
			<td>Contact No. :</td>
			<td>${enquiry.contactNo}</td>
		</tr>
		<tr>
			<td>Contact Email :</td>
			<td>${enquiry.contactMail}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td>${enquiry.description}</td>
		</tr>
		<tr>
			<td>Status :</td>
			<td>${enquiry.status}</td>
		</tr>
	</table>
	<table align="center" cellpadding="40">
		<c:set var="status" value="${enquiry.status}" />
		<c:if test="${status eq 'Pending'}">
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/enquiry-status-update.htm?update=A&enquiryId=${enquiry.merchantEnquiryId}"><button>Approve</button></a></td>
				<td align="left"><a
					href="${pageContext.request.contextPath}/enquiry-status-update.htm?update=R&enquiryId=${enquiry.merchantEnquiryId}"><button>Reject</button></a></td>
			</tr>
		</c:if>
	</table>
</div>