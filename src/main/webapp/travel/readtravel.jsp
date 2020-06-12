<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TravelDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Team Read">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Team</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
  <div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
  </div>
 <br>

	<div class="main">
		<%
			TravelDTO t = (TravelDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Travel Date</th>
				<th>Passenger</th>
				<th>Truck</th>
				<th>City</th>
				
			</tr>
			<tr>
				<td><%=t.getId()%></td>
				<td><%=t.getTraveldate()%></td>
				<td><%=t.getPassenger()%></td>
				<td><%=t.getTruck()%></td>
				<td><%=t.getCity() %></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>