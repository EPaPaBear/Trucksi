<%@ page import="it.contrader.dto.TruckDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Truck Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Truck Manager</title>

</head>
<body>
	<%@ include file="/css/header.jsp"%>
	<%@include file="/common-content/menu.jsp" %>
	
	
	<div class="main">
		<%
			List<TruckDTO> list = (List<TruckDTO>) request.getSession().getAttribute("list");
			System.out.println(list);
		%>

		<br>

		<table>
			<tr>
				<th>How Many People</th>
				<th>License Plate</th>
				<th>People Booking</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TruckDTO t : list) {
			%>
			<tr>
				<td>
					<a href="/truck/read?id=<%=t.getId()%>"> <%=t.getLicensePlate()%></a> 
				</td>
				<td><%=t.getHowManyPeople()%></td>
				<td><%=t.getLicensePlate()%></td>
				<td><a href="/truck/preupdate?id=<%=t.getId()%>">Edit</a></td>


				<td><a href="/truck/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/truck/insert" method="post">
			<div class="row">
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
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>
</body>
</html>