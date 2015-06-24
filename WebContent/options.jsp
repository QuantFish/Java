<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="controller.OptionsController.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="quantfish.css" rel="stylesheet" type="text/css">

<title>QuantFish - Options</title>
</head>
<body>

	<p>Welcome to the options pricing module, using the Black Scholes
		basic model. The futures calculation from 1976 and continuous yield
		model.</p>

	<form action="${pageContext.request.contextPath}/OptionsController"
		method="post">
		<input type="hidden" name="action" value="docalculate" /> 
		Spot Price: £ <input type="text" name="sprice"
			value="<%if (request.getAttribute("sprice") != null) {
				out.print(request.getAttribute("sprice"));
			}%>" />
		<p />
		Strike Price: £ <input type="text" name="strike"
			value="<%if (request.getAttribute("strike") != null) {
				out.print(request.getAttribute("strike"));
			}%>" />
		<p />
		Risk Free Rate: <input type="text" name="rate"
			value="<%if (request.getAttribute("rate") != null) {
				out.print(request.getAttribute("rate"));
			}%>" />
		<p />

		Months To Expire: <input type="text" name="time"
			value="<%if (request.getAttribute("time") != null) {
				out.print(request.getAttribute("time"));
			}%>" />
		<p />

		Volatility: <input type="text" name="volatility"
			value="<%if (request.getAttribute("volatility") != null) {
				out.print(request.getAttribute("volatility"));
			}%>" />

		<p />
		<input type="submit" value="Submit" />
	</form>
	<p />
	<p />
	One CALL option costs: £
	<b><fmt:formatNumber value='${validation1}' maxFractionDigits='4' /></b>
	<p />
	One PUT option costs: £
	<b><fmt:formatNumber value='${validation2}' maxFractionDigits='4' /></b>
	<p />
	

</body>
</html>