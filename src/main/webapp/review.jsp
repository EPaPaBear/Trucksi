<%@ page import="it.contrader.dto.CityDTO" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>

	<div class="main">
		<%
			//List<CityDTO> list = (List<CityDTO>) request.getSession().getAttribute("listC"); 
			//System.out.println(list);
		%>

		<br>

		<table>
			<tr>
				<th>Reviews</th>
				<th></th>
				<th></th>
			</tr>
			<%
				//for (CityDTO t : list) {
			%>
			<tr>
				<td>
					<a href="/city/read?id=<%//=t.getId()%>"> <%//=t.getCityname()%></a>  
				</td>
				<td><a href="/city/preupdate?id=<%//=t.getId()%>">Edit</a></td>


				<td><a href="/city/delete?id=<%//=t.getId()%>">Delete</a></td>

			</tr>
			<%
				//}
			%>
		</table>



		<form id="floatright"  action="/city/insert" method="post">
			<th>You travelled from x to y on DD/MM/YYYY</th>
			<th></th>
			<th></th>
		 	<fieldset>
			<legend>Stars</legend>
			<select name="siti" >
			<option value="1" selected="selected">1 </option>
			<option value="2">2 </option>
			<option value="3">3 </option>
			<option value="4">4 </option>
			<option value="5">5 </option>
			</select>
			</fieldset>
			<div class="row">
				<div class="col-25">
					<label for="city">Leave a comment</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="cityname"
						placeholder="Comment">
				</div>
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
<%@ include file="/css/footer2.jsp"%>