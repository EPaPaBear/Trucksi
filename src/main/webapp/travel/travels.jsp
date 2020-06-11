<%@ page import="it.contrader.dto.TravelDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Team Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Travel Manager</title>

</head>
<body>
	<%@ include file="/css/header.jsp"%>
	<%@include file="/common-content/menu.jsp" %>
	
	</div>
	<div class="main">
		<%
			List<TravelDTO> list = (List<TravelDTO>) request.getSession().getAttribute("listT");
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
				for (TravelDTO t : list) {
			%>
			<tr>
				<td><a href="/travel/read?idt=<%=t.getId()%>"> <%=t.getTraveldate()%>
				</a></td>
				<td><%=t.getPassenger()%></td>
				<td><%=t.getTruck()%></td>
				<td><a href="/travel/preupdate?idt=<%=t.getId()%>">Edit</a></td>


				<td><a href="/travel/delete?idt=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/travel/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="nteam">Travel Date</label>
				</div>
				<div class="col-75">
					<input type="text" id="traveldate" name="traveldate"
						placeholder="Insert Travel Date">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="descr">Passenger</label>
				</div>
				<div class="col-75">
					<input type="text" id="passenger" name="passenger"
						placeholder="Insert Passenger">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="nutenti">Truck</label>
				</div>
				<div class="col-75">
					<input type="text" id="truck" name="truck"
					placeholder="Insert Truck">
						

				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="/css/footer.jsp"%>
</body>
</html>