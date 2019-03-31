<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body bgcolor="lightyellow">
	Hello, ${pageContext.request.userPrincipal.name}
	<%
		/* System.out.println(request.getUserPrincipal().getName().toString()); */
	%>
</body>
</html>


<%-- <c:choose>
						<c:when test="${pageContext.request.userPrincipal.name == null}">
							<li><label class="logoutPos"><a
									href="./logout"><button type="button">Logout</button></a></label></li>
							<!-- <label class="enquiryPos"><a
									href="./wegift-merchant-web/merchant-enquiry.htm">Have a
										Business..? Join with Us..</a></label> -->
						</c:when>
						<c:otherwise>
							<!-- <label class="logoPos"><a href="./home.htm"><img
										src="img/gift-3-xxl.png" width="100px" height="110px"></a></label> -->
							<li><label class="loginPos"><a href="./login.htm"><button
											type="button">Login</button></a> </label></li>
							<li><label class="registerPos"><a
									href="./member-reg.htm"><button type="button">Register</button></a></label></li>
							<!-- <label class="enquiryPos"><a href="./merchant-reg.htm">Have
										a Business..? Join with Us..</a></label> -->
						</c:otherwise>
					</c:choose>
 --%>