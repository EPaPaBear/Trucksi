<%@page import="it.contrader.model.Travel"%>
<%@page import="it.contrader.dto.TruckDTO"%>
<%@page import="it.contrader.model.Truck"%>
<%@page import="it.contrader.service.CityService"%>
<%@page import="it.contrader.dto.CityDTO"%>
<%@page import="it.contrader.model.City"%>
<%@ page import="it.contrader.dto.HystorytravelDTO" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>
	
	
	<div class="main">
		<%
		//List<HystorytravelDTO> list = (List<HystorytravelDTO>) request.getSession().getAttribute("listH"); 
			List<CityDTO> listM = (List<CityDTO>) request.getSession().getAttribute("listM");
			List<TruckDTO> listT = (List<TruckDTO>) request.getSession().getAttribute("listT");
		//	CityService serviceC = new CityService();
			Travel tr =  (Travel) request.getSession().getAttribute("TravelID");
			
			
		%>

		<br>

	
	


		<form id="floatright" name="form" action="/hystorytravel/inserth" method="post" >
			<div class="row">
	    <div class="col-25">
	      <label for="city"> Date selected:</label>
	     </div>
	     <div class="col-75">
			<input type="text" value="<%=tr.getDate()%>" readonly>
			
			
	    </div>
	</div>
		<!--  se sei admin tutti i driver  -->
	 <input type="hidden" id="custId" name="id" value="<%=tr.getId()%>">
	<!--  truck select -->
	<div class="row">
	    <div class="col-25">
	      <label for="city"> Select Truck:</label>
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
	      <label for="city"> Departure City:</label>
	     </div>
	     <div class="col-75">
			<select name="citydeparture" id="citydeparture" required>
			 <option value="">None</option>
				<%for (CityDTO ltc : listM) { %>
  					<option value="<%=ltc.getId()%>" > <%=ltc.getCityname() %></option>
				<%}%>
			</select>
	    </div>
	</div>
<!--  departure city -->
	<!--  time departure ok -->
	<div class="row">
	    <div class="col-25">
	     <label for="date">Departure time </label>
	    </div>
	    <div class="col-75">
		<input type="time" id="time" name="timedeparture"
       min="00:00" max="23:59" required>
	    </div>
	  </div>
	<!--  departure time -->	
	<!--  arrival city -->
	<div class="row">
	    <div class="col-25">
	      <label for="city"> Arrival City :</label>
	     </div>
	     <div class="col-75">
			<select name="cityarrive" id="city" required>
			 <option value="">None</option>
				<%for (CityDTO ltc : listM) { %>
  					<option value="<%=ltc.getId()%>" > <%=ltc.getCityname() %></option>
				<%}%>
			</select>
	 	</div>
	 </div>
	 <!--  arrival city -->
	 	<!--  time departure ok -->
	<div class="row">
	    <div class="col-25">
	     <label for="date">Arrival time: </label>
	    </div>
	    <div class="col-75">
		<input type="time" id="time" name="timearrival"
       min="00:00" max="23:59" required>
	    </div>
	  </div>
	<!--  departure time -->
	<!--  		<div class="row">
				<div class="col-25">
					<label for="truck">License Plate</label>
				</div>
				<div class="col-75">
					<input type="text" id="truck" name="licensePlate"
						placeholder="Enter License Plate">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="howManyPeople">How Many People</label>
				</div>
				<div class="col-75">
					<input type="text" id="howManyPeople" name="howManyPeople"
						placeholder="Enter How Many People">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="peopleBooking">People Booking</label>
				</div>
				<div class="col-75">
					<input type="text" id="peopleBooking" name="peopleBooking"
						placeholder="Enter People Booking">
				</div>
			</div> -->
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
<%@ include file="/css/footer2.jsp"%>