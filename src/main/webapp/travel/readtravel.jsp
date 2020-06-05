<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TravelDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title> Read Travel</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>

<div class="main">
<%TravelDTO t = (TravelDTO) request.getAttribute("dto");%> 


<table class="full">
	<tr> 
		<th>Username ID</th>
		<th>Truck ID</th>
		<th>City ID</th>
		<th>History ID </th>
	</tr>
	<tr>
		<td> <%=t.getIdusername()%></td>
		<td> <%=t.getIdtruck()%></td>
		<td> <%=t.getIdcity()%></td>
		<td> <%=t.getIdhistory() %>
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