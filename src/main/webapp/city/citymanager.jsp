<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.CityDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>City Manager</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>


<%@ include file="/common-content/menu.jsp" %>

<div class="main">
	<%
		List<CityDTO> list = (List<CityDTO>) request.getAttribute("list");
	%>
	
	<table> 
		<tr>
			<th>City name</th>
				<th>Actions</th>
		</tr>
		<%
			for (CityDTO t : list) { 
		%>
		<tr>
			<td><a href=TruckServlet?mode=read&id=<%=t.getId()%>>
					<%=t.getCityname()%>
			</a></td>
				<td><a class="edit" href=CityServlet?mode=read&update=true&id=<%=t.getId()%>></a>&nbsp;&nbsp;<!-- Blank fields -->
					<a class="delete" href=CityServlet?mode=delete&id=<%=t.getId()%>></a>	<!-- Icon links within themed actions  -->
				</td>
		</tr>
		<%
			}
		%>
	</table>


	<form id="floatright" action="CityServlet?mode=insert" method="post">
	  
	  <div class="row">
	    <div class="col-40">
	      <label for="user">City name</label>
	    </div>
	    <div class="col-60"> 
	      <input type="text" id="cityname" name="cityname" placeholder="Insert city name" required>
	    </div>
	  </div>
	      <button type="submit" >Insert</button>
	</form>


</div>
<br>
<%@ include file="/css/footer.jsp" %>
</body>
</html>