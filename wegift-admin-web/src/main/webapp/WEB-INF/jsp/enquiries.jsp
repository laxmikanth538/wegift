<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<title>List Of Enquiries</title>
<div class="reg-font">
	<h2 align="center" style="font-family: arial">Enquiries</h2>
	<table align="center" border="1" cellpadding="7">
		<c:if test="${empty enquiries}">
			<p style="color: red" align="center">Requested Enquiries are not available</p>
		</c:if>
		<c:if test="${not empty enquiries}">
			<tr>
				<th>Enquiry Id</th>
				<th>Organisation Name</th>
				<th>Location</th>
				<th>Contact Person</th>
				<th>Contact No.</th>
				<th>Status</th>
			</tr>
			<c:set var="enquiries" value="${enquiries}" />
			<c:forEach items="${enquiries}" var="enquiry">
				<tr>
					<td>${enquiry.merchantEnquiryId}</td>
					<td><a
						href="${pageContext.request.contextPath}/specific-merchant-enquiry.htm?orgName=${enquiry.organizationName}">${enquiry.organizationName}</a></td>
					<td>${enquiry.merchantLocation}</td>
					<td>${enquiry.contactPerson}</td>
					<td>${enquiry.contactNo}</td>
					<td align="center">${enquiry.status}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:set var="enquiries" value="${enquiries}" />
	<c:if test="${not empty enquiries}">
		<table border="0" align="center">
			<tr align="center">
			<c:set var="count" value="${size%6}" />
			<c:forEach begin="0"  var="i" end="${count+1}">
				<td align="center"><a
					href="${pageContext.request.contextPath}/enquiries.htm?status=${status}&pageNo=${i}"><button
							style="height: 40px; width: 40px">${i+1}</button></a></td>
			</c:forEach>
			</tr>
		</table>
	</c:if>
</div>
