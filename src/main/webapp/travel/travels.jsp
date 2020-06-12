<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import="it.contrader.dto.TravelDTO" import="it.contrader.dto.TruckDTO" import="java.util.*" import="java.time.*" import ="it.contrader.dto.PassengerDTO"%>
<%@ page import ="it.contrader.dto.CityDTO" %>
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
	<%@ include file="/css/header2.jsp"%>
		
	<div class="main">
		<% 
		List<TravelDTO> travelList = (List<TravelDTO>) request.getSession().getAttribute("listT");
		List<TruckDTO> truckList = (List<TruckDTO>) request.getSession().getAttribute("TruckList");
		List<PassengerDTO> passengerList = (List<PassengerDTO>) request.getSession().getAttribute("PassengerList");
		List<CityDTO> cityList = (List<CityDTO>) request.getSession().getAttribute("CityList");
		%>
<br>
		<table>
		<tr>
				<th>Travel ID</th>
				<th>Travel Date</th>
				<th>Passenger</th>
				<th>Truck</th>
				<th>City</th>
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
			<td><%=e.getCity()%>
			<td><a href=/travel/preupdate?id=<%=e.getId() %>>Edit</a></td>
			<td><a href=/travel/delete?id=<%=e.getId() %>>Delete</a></td>			
		</tr>
		<% } %>	
	</table>
</div>
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
	      <label for="city">City</label>
	     </div>
	     <div class="col-75">
			<select name="cityname" id="city" required>
			 <option value="">None</option>
				<%for (CityDTO city : cityList) { %>
  					<option value="<%=city.getId()%>" > <%=city.getCityname() %></option>
				<%}%>
			</select>
	 	</div>
	 </div>
		<div class="row">
	    <div class="col-25">
	      <label for="pass">Passenger</label>
	     </div>
	     <div class="col-75">
			<select name="name" id="pass" required>
			 <option value="">None</option>
				<%for (PassengerDTO p : passengerList) { %>
  					<option value="<%=p.getId()%>" > <%=p.getName()%></option>
				<%}%>
			</select>
	 	</div>
	 </div>
	
	<button type="submit">Insert</button>
</form>
<%@ include file="/css/footer2.jsp"%>
</body>
</html>