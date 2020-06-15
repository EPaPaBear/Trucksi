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
			List<TruckDTO> listT = (List<TruckDTO>) request.getSession().getAttribute("listT");	
		%>

		<br>

		<table>
			<tr>
				<th>Vehicle Model</th>
				<th>Date</th>
				<th>Hystory Travel</th>
				<th>Edit</th>
				<th>Delete</th>
				
			</tr>
			<%
				for (TravelDTO t : list) {
		%>
			<tr>
				<td><%=t.getTruck().getModel()%></td>
				<td><%=t.getDate()%></td>
				<td><a href="/hystorytravel/inserthystory?id=<%=t.getId()%>">Insert Hystory</a></td>
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

<div class="row">
		<div class="col-25">
		 <label for="date">Date</label>
		</div>
		<div class="col-75">
		 <input type="date" id="date" name="date">
		</div>
</div>

<button type="submit">Insert</button>
</form>
</div>
<br>
<%@ include file="/css/footer2.jsp"%>