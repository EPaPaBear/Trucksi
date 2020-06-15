<%@ page import="it.contrader.dto.CityDTO" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>
	
	
	<div class="main">
		<%
			List<CityDTO> list = (List<CityDTO>) request.getSession().getAttribute("listC");
		%>

		<br>

		<table>
			<tr>
				<th>City name</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CityDTO t : list) {
			%>
			<tr>
				<td>
					<a href="/city/read?id=<%=t.getId()%>"> <%=t.getCityname()%></a>  
				</td>
				<td><a href="/city/preupdate?id=<%=t.getId()%>">Edit</a></td>

				<td><a href="/city/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/city/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="city">City name</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="cityname"
						placeholder="Enter city name">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
<%@ include file="/css/footer2.jsp"%>