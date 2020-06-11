<%@ page import="it.contrader.dto.TruckDTO" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>
	
	
	<div class="main">
		<%
			List<TruckDTO> list = (List<TruckDTO>) request.getSession().getAttribute("listT"); 
		%>

		<br>

		<table>
			<tr>
				<th>License Plate</th>
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
<%@ include file="/css/footer2.jsp"%>