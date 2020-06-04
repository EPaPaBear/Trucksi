<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TruckDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>Read Track</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>

<div class="main">
<%TruckDTO t = (TruckDTO) request.getAttribute("dto");%> 


<table class="full">
	<tr> 
		<th>License Plate</th>
		<th>How Many People</th>
		<th>People Booking</th>
	</tr>
	<tr>
		<td> <%=t.getLicensePlate()%></td>
		<td> <%=t.getHowManyPeople()%></td>
		<td> <%=t.getPeopleBooking()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="/css/footer.jsp" %>
</body>
</html>