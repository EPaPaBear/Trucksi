<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.HystorytravelDTO"
    import="java.util.List"
    import="it.contrader.dto.UserDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hystory travel</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
	<%
		List<HystorytravelDTO> list = (List<HystorytravelDTO>) request.getAttribute("list");
		UserDTO user = (UserDTO) session.getAttribute("user") ; 
		String user_type = user.getUsertype().toUpperCase(); 
	%>
	
	<table <% if(!user_type.equals("ADMIN")) out.println("class=\"full\""); %>> 
		<tr>
			<th>idtravel</th>
			<th>idcity</th>
			<th>date</th>
			<th>travelindex</th>
			<% if(user_type.equals("ADMIN")){ %>
				<th>Actions</th>
			<% } %>
		</tr>
		<%
			for (HystorytravelDTO t : list) { 
		%>
		<tr>
			<td><a href=TruckServlet?mode=read&id=<%=t.getId()%> >
			<%=t.getIdtravel() %></a></td>
			<td><%=t.getIdcity()%></td>
			<td><%=t.getDate()%></td>
			<td><%=t.getTravelindex() %> </td>
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
	
</div>
</body>
</html>