<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.TravelDTO"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>Travel Manager</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>


<%@ include file="/common-content/menu.jsp" %>

<div class="main">
	<%
		List<TravelDTO> list = (List<TravelDTO>) request.getAttribute("list");
		UserDTO user = (UserDTO) session.getAttribute("user") ; 
		String user_type = user.getUsertype().toUpperCase(); 
	%>
	
	<table <% if(!user_type.equals("ADMIN")) out.println("class=\"full\""); %>> 
		<tr>
			<th>Username ID</th>
			<th>Truck ID</th>
			<th>City ID</th>
			<th>History ID </th>
			<% if(user_type.equals("ADMIN")){ %>
				<th>Actions</th>
			<% } %>
		</tr>
		<%
			for (TravelDTO t : list) { 
		%>
		<tr>
			<td><a href=TruckServlet?mode=read&id=<%=t.getId()%>>
					<%=t.getIdusername()%>
			</a></td>
			<td><%=t.getIdtruck()%></td>
			<td><%=t.getIdcity()%></td>
			<td><%=t.getIdhistory() %> </td>
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
	<form id="floatright" action="TravelServlet?mode=insert" method="post">
	  
	  <div class="row">
	    <div class="col-40">
	      <label for="user">Username ID</label>
	    </div>
	    <div class="col-60"> 
	      <input type="text" id="idusername" name="idusername" placeholder="Insert Username ID" required>
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-40">
	     <label for="pass">Truck ID</label>
	    </div>
	    <div class="col-60">
	      <input type="number" id="idtruck" name="idtruck" min="0" placeholder="Insert Truck ID" required> 
	    </div>
	  </div>
	  
	  <div class="row">
	    <div class="col-40">
	      <label for="type">City Id </label>
	    </div>
	  	<div class="col-60">
			<input type="number" id="idcity" name="idcity" min="0" placeholder="Insert City ID" required> 
	   	</div>
	  </div>
	  
	   <div class="row">
	    <div class="col-40">
	      <label for="type">History ID </label>
	    </div>
	  	<div class="col-60">
			<input type="number" id="idhistory" name="idhistory" min="0" placeholder="Insert History ID" required> 
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