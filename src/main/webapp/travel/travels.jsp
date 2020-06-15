<%@page import="it.contrader.dto.TruckDTO"%>
<%@page import="it.contrader.model.Truck"%>
<%@page import="it.contrader.service.CityService"%>
<%@page import="it.contrader.dto.CityDTO"%>
<%@page import="it.contrader.model.City"%>
<%@ page import="it.contrader.dto.TravelDTO" import="java.util.*"%>
<%@ page import="it.contrader.dto.PassengerDTO"%>
<%@ include file="/css/header2.jsp"%>
	
	
	<div class="main">
		<%
			List<TravelDTO> list = (List<TravelDTO>) request.getSession().getAttribute("list"); 
			List<CityDTO> listC = (List<CityDTO>) request.getSession().getAttribute("listC");
			List<TruckDTO> listT = (List<TruckDTO>) request.getSession().getAttribute("listT");
			List<PassengerDTO> listP = (List<PassengerDTO>) request.getSession().getAttribute("listP");
			CityService serviceC = new CityService();
			
			
		%>

		<br>

		<table>
			<tr>
				<th>Passenger's Name</th>
				<th>Departure</th>
				<th>Arrival</th>
				<th>Vehicle Model</th>
				<th>Date</th>
				<th> </th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TravelDTO t : list) {
		%>
			<tr>
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
	


<form id="floatright" name="form" action="/travel/insert" method="post" >
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
		<!--  select su truck    -->
		<!--  select travel  -->
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

<!--  departure city -->
<!--  time departure ok -->
<!--  
<div class="row">
	    <div class="col-25">
	     <label for="date">time </label>
	    </div>
	    <div class="col-75">
		<input type="time" id="time" name="timedeparture"
       min="00:00" max="23:59" required>
	    </div>
	  </div>
	  
-->
<!--  departure time -->	
<!--  arrival city -->
	
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
	 <!--  arrival city -->
	 <!--  time departure ok -->
<!--  	 
<div class="row">
	    <div class="col-25">
	     <label for="date">Arrival time: </label>
	    </div>
	    <div class="col-75">
		<input type="time" id="time" name="timearrival"
       min="00:00" max="23:59" required>
	    </div>
</div>
-->
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

<button type="submit">Insert</button>
</form>

</div>
<br>
<%@ include file="/css/footer2.jsp"%>