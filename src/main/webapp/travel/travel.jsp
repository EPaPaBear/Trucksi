<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Manager</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
  
</head>
<body>
<div class="main">

	<%@include file="/common-content/menu.jsp" %>
<table <% //if(!user_type.equals("ADMIN")) out.println("class=\"full\""); %>> 
		<tr>
			<th>Nome viaggio</th>
			<th>partenza</th>
			<th>arrivo</th>
			<th>data</th>
			<th>orario partenza </th>
			<th>orario arrivo <th>
			<% //if(user_type.equals("ADMIN")){ %>
				<th>Actions</th>
			<% // } %>
		</tr>
		<tr>
			<td>1<a href=HystorytravelServlet?mode=read&id=<%//=t.getId()%> >
			<%//=t.getIdtravel() %></a></td>
			<td>2<%//=t.getIdcity()%></td>
			<td>3<%//=t.getDate()%></td>
			<td>4<%//=t.getTravelindex() %> </td>
			<td>5</td>
			<% // if(user_type.equals("ADMIN")){ %>
				<td><a class="edit" href=HystorytravelServlet?mode=read&update=true&id=<%//=t.getId()%>>6</a>&nbsp;&nbsp;<!-- Blank fields -->
					<a class="delete" href=HystorytravelServlet?mode=delete&id=<%//=t.getId()%>>7</a>	<!-- Icon links within themed actions  -->
				</td>
			<%// } %>
		</tr>
		<%
		//	}
		%>
</table>
<form id="floatright" action="/travel/submit" method="post">	  
	<!--  <div class="row">
	    <div class="col-40">
	      <label for="travel">travel:</label>
	         </div>
	     <div class="col-60">
			<select name="travel" id="travel">
				<%//for (TravelDTO lt : lts) { %>
  					<option value="<%//=lt.getId()%>"><%//=lt.getId()%></option>
				<%//}%>
			</select>
	    </div> 
	</div> -->
	<!--  departure city -->
	<div class="row">
	    <div class="col-40">
	      <label for="city"> Departure City:</label>
	     </div>
	     <div class="col-60">
			<select name="citydeparture" id="city">
				<%//for (CityDTO ltc : ltcs) { %>
  					<option value="1" > Roma <%//=ltc.getCityname() %></option>
				<%//}%>
			</select>
	    </div>
	</div>
	<!--  departure city -->
	
	
	
	
	<!--  time departure ok -->
	<div class="row">
	    <div class="col-40">
	     <label for="date">Departure time </label>
	    </div>
	    <div class="col-60">
		<input type="time" id="time" name="timedeparture"
       min="09:00" max="24:00" required>
	    </div>
	  </div>
	<!--  departure time -->	
	
	
	
	<!--  arrival city -->
	<div class="row">
	    <div class="col-40">
	      <label for="city"> Arrival City :</label>
	     </div>
	     <div class="col-60">
			<select name="arrivalcity" id="city">
				<%//for (CityDTO ltc : ltcs) { %>
  					<option value="2" <%//=ltc.getId()%>> milano <%//=ltc.getCityname() %></option>
				<%//}%>
			</select>
	 	</div>
	 </div>
	 <!--  arrival city -->
	 
	 
	 
	 
	 <!--  arrival time  -->
	  <div class="row">
	    <div class="col-40">
	     <label for="arrivaltime">Arrival Time:</label>
	    </div>
	    <div class="col-60">
	<input type="time" id="appt" name="arrivaltime"
       min="09:00" max="24:00" required>
	    </div>
	  </div>
	  <!--  arrival time -->
	
	
	
	

	
	
	
	<!--  departure date -->
	<div class="row">
	    <div class="col-40">
	     <label for="departuretime">Departure date :</label>
	    </div>
	    <div class="col-60">
	<input  id="datepicker" name="departuredate"
       min="09:00" max="24:00" required>
	    </div>
	  </div>
	<!--  departure date -->	
	
	
	 <!--  
	   <div class="row">
	    <div class="col-40">
	     <label for="date">TravelIndex:</label>
	    </div>
	    <div class="col-60">
		  <input type="text" id="datepicker" name="travelindex" value="<%//=travelindex %>">
	    </div>
	  </div> -->
	   <button type="submit" >Insert</button>
</form>
	

</div>


</body>
</html>