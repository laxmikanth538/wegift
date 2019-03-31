<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/style1.css">
<label class="logoPos"><a href="./home.htm"><img
		src="img/gift-3-xxl.png" width="100px" height="110px"></a></label>


<%-- <%
	if (session == null) {
%>

<label class="logoutPos"><a href="./wegift-merchant-web/logout"><button
			type="button">Logout</button></a></label>
<label class="enquiryPos"><a
	href="./wegift-merchant-web/merchant-enquiry.htm">Have a
		Business..? Join with Us..</a></label>
<%
	} else {
%>
<label class="logoPos"><a href="./home.htm"><img
		src="img/gift-3-xxl.png" width="100px" height="110px"></a></label>
<label class="loginPos"><a href="./login.htm"><button
			type="button">Login</button></a> </label>
<label class="registerPos"><a href="./member-reg.htm"><button
			type="button">Register</button></a></label>
<label class="enquiryPos"><a href="./merchant-reg.htm">Have
		a Business..? Join with Us..</a></label>

	
<%
	}
%>
 --%>
<%-- <c:choose>
	<c:when test="${pageContext.request.userPrincipal.name != null}">
		<label class="logoutPos"><a
			href="./wegift-merchant-web/logout"><button type="button">Logout</button></a></label>
		<label class="enquiryPos"><a
			href="./wegift-merchant-web/merchant-enquiry.htm">Have a
				Business..? Join with Us..</a></label>
	</c:when>
	<c:otherwise>
		<label class="logoPos"><a href="./home.htm"><img
				src="img/gift-3-xxl.png" width="100px" height="110px"></a></label>
		<label class="loginPos"><a href="./login.htm"><button
					type="button">Login</button></a> </label>
		<label class="registerPos"><a href="./member-reg.htm"><button
					type="button">Register</button></a></label>
		<label class="enquiryPos"><a href="./merchant-reg.htm">Have
				a Business..? Join with Us..</a></label>
	</c:otherwise>
</c:choose> --%>
