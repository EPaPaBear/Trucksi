<%@page import="it.contrader.dto.TruckDTO"%>
<%@page import="it.contrader.model.Truck"%>
<%@page import="it.contrader.service.CityService"%>
<%@page import="it.contrader.dto.CityDTO"%>
<%@page import="it.contrader.model.City"%>
<%@ page import="it.contrader.dto.TravelDTO" import="java.util.*"%>
<%@ page import="it.contrader.dto.PassengerDTO"%>
<%@ include file="/css/header2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Travel</title>

</head>
<body>
<div class="main">

<%
			List<TravelDTO> list = (List<TravelDTO>) request.getSession().getAttribute("list"); 
			List<CityDTO> listC = (List<CityDTO>) request.getSession().getAttribute("listC");
			List<TruckDTO> listT = (List<TruckDTO>) request.getSession().getAttribute("listT");
			List<PassengerDTO> listP = (List<PassengerDTO>) request.getSession().getAttribute("listP");
			CityService serviceC = new CityService();	
			
%>


<form id="floatright" name="form" action="/travel/update" method="post" >
<!--  truck select -->
	<div class="row">
	    <div class="col-25">
	      <label for="truck">Vehicle</label>
	     </div>
	     <div class="col-75">
			<select name="truck" id="truck" required>
			 <option value="">None</option>
				<%for (TruckDTO ltt : listT) { %>
  					<option value="<%=ltt.getId()%>" > <%=ltt.getModel() %></option>
				<%}%>
			</select>
	    </div>
	</div>

<!--  departure city -->
	<div class="row">
	    <div class="col-25">
	      <label for="city">Departure</label>
</div>
	     <div class="col-75">
			<select name="citydeparture" id="citydeparture" required>
			 <option value="">None</option>
				<%for (CityDTO ltc : listC) { %>
  					<option value="<%=ltc.getId()%>" > <%=ltc.getCityname() %></option>
				<%}%>
			</select>
	    </div>
</div>

<div class="row">
	    <div class="col-25">
	      <label for="city">Arrival</label>
	     </div>
	     <div class="col-75">
			<select name="cityarrive" id="city" required>
			 <option value="">None</option>
				<%for (CityDTO ltc : listC) { %>
  					<option value="<%=ltc.getId()%>" > <%=ltc.getCityname() %></option>
				<%}%>
			</select>
	 	</div>
</div>

<div class="row">
	    <div class="col-25">
	      <label for="city">Passenger</label>
	     </div>
	     <div class="col-75">
			<select name="passenger" id="passenger" required>
			 <option value="">None</option>
				<%for (PassengerDTO pass : listP) { %>
  					<option value="<%=pass.getId()%>" > <%=pass.getName() %></option>
				<%}%>
			</select>
	 	</div>
</div>

<button type="submit">Update</button>
</form>

</div>
<br>
<%@ include file="/css/footer2.jsp"%>