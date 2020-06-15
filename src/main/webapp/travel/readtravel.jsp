<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.TravelDTO" import ="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Travel</title>
</head>





<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			List<TravelDTO> list = (List<TravelDTO>) request.getSession().getAttribute("list"); 
		%>


		<table>
			<tr>
				<th>id</th>
				<th>Passenger's Name</th>
				<th>Departure</th>
				<th>Arrival</th>
				<th>Vehicle Model</th>
				<th>Date</th>
			</tr>
			<%
				for (TravelDTO t : list) {
		%>
			<tr>
				<td>
					<a href="/travel/read?id=<%=t.getId()%>"><%=t.getId() %> </a>  
				</td>
				<td><%=t.getPassenger().getName() %></td>
				<td> <%=t.getCitydeparture().getCityname() %></td>
				<td> <%=t.getCityarrive().getCityname() %></td>
				<td><%=t.getTruck().getModel()%>  </td>
				<td></td>
				
				<td><a href="/travel/preupdate?id=<%=t.getId()%>">Edit</a></td>
				<td><a href="/travel/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
	</div>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>