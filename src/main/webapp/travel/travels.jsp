<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.TravelDTO" import="it.contrader.dto.TruckDTO" import="java.util.*" import="java.time.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Event Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">

<title>Travel Manager</title>
		
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	
	<div class="main">
		<% 
		List<TravelDTO> travelList = (List<TravelDTO>) request.getSession().getAttribute("listT");
		%>
		<% 
		List<TruckDTO> truckList = (List<TruckDTO>) request.getSession().getAttribute("TruckList");
		%>
		
<br>
		<table>
		
		<tr>
				<th>Travel ID</th>
				<th>Travel Date</th>
				<th>Passenger</th>
				<th>Truck</th>
		</tr>
		
		<%
			for(TravelDTO e : travelList){	
		%>
		<tr>
			<td>#</td>
			<td><%=e.getId()%></td>
			<td><%=e.getTraveldate().format((DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")))%></td>
			<td><%=e.getPassenger() %></td>
			<td><%=e.getTruck()%></td>	
			<td><a href=/travel/preupdate?id=<%=e.getId() %>>Edit</a></td>
			<td><a href=/travel/delete?id=<%=e.getId() %>>Delete</a></td>			
		</tr>
		<% } %>	
	</table>
	
<br>
<br>
	<form id="floatright" action="/travel/insert" method="post">
	<div class="row">
		<div class="col-25">
		 <label for="name">Travel ID</label>
		</div>
		<div class="col-75">
		 <input type="text" id="Id" name="id" placeholder="Travel Id">
		</div>
	</div>
	
		<div class="row">
	    <div class="col-25">
	      <label for="truck">Truck</label>
	     </div>
	     <div class="col-75">
			<select name="licenceplate" id="truck" required>
			 <option value="">None</option>
				<%for (TruckDTO ltc : truckList) { %>
  					<option value="<%=ltc.getId()%>" > <%=ltc.getLicensePlate() %></option>
				<%}%>
			</select>
	 	</div>
	 </div>
	
	
	
	<div class="row">
		<div class="col-25">
		 <label for="startDate">Departure Date</label>
		</div>
		<div class="col-75">
		 <input type="datetime-local" id="startDate" name="startDate">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
		 <label for="category">Passenger</label>
		</div>
		<div class="col-75">
		 <input list="passenger" name="passenger" placeholder="Passenger Name">
		</div>
	</div>
	
	<button type="submit">Insert</button>
</form>
<%@ include file="../css/footer.jsp"%>
</body>
</html>