<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.TruckDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>Truck Manager</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>


<%@ include file="/common-content/menu.jsp" %>

<div class="main">
	<%
		List<TruckDTO> list = (List<TruckDTO>) request.getAttribute("list");
		UserDTO user = (UserDTO) session.getAttribute("user") ; 
		String user_type = user.getUsertype().toUpperCase();
	%>
	
<br>

	<table <% if(!user_type.equals("ADMIN")) out.println("class=\"full\""); %>>
		<tr>
			<th>License Plate</th>
			<th>How Many People</th>
			<th>People Booking</th>
			<% if(user_type.equals("ADMIN")){ %>
				<th>Actions</th>
			<% } %>
		</tr>
		<%
			for (TruckDTO t : list) { 
		%>
		<tr>
			<td><a href=TruckServlet?mode=read&id=<%=t.getId()%>>
					<%=t.getLicensePlate()%>
			</a></td>
			<td><%=t.getHowManyPeople()%></td>
			<td><%=t.getPeopleBooking()%></td>
			<% if(user_type.equals("ADMIN")){ %>
				<td><a class="edit" href=TruckServlet?mode=read&update=true&id=<%=t.getId()%>></a>&nbsp;&nbsp;<!-- Blank fields -->
					<a class="delete" href=TruckServlet?mode=delete&id=<%=t.getId()%>></a>	<!-- Icon links within themed actions  -->
				</td>
			<% } %>
		</tr>
		<%
			}
		%>
	</table>


<% if(user_type.equals("ADMIN")){ %>
	<form id="floatright" action="TruckServlet?mode=insert" method="post">
	  
	  <div class="row">
	    <div class="col-40">
	      <label for="user">License Plate</label>
	    </div>
	    <div class="col-60"> 
	      <input type="text" id="licenseplate" name="licenseplate" placeholder="Insert License Plate" required>
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-40">
	     <label for="pass">How Many People</label>
	    </div>
	    <div class="col-60">
	      <input type="number" id="howmanypeople" name="howmanypeople" min="0" placeholder="Insert How Many People" required> 
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-40">
	      <label for="type">People Booking</label>
	    </div>
	  	<div class="col-60">
			<input type="number" id="peoplebooking" name="peoplebooking" min="0" placeholder="Insert People Booking" required> 
	   	</div>
	  </div>
	      <button type="submit" >Insert</button>
	</form>

<% } %>

</div>
<br>
<%@ include file="/css/footer.jsp" %>
</body>
</html>