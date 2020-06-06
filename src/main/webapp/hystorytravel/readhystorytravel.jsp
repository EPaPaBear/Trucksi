<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.contrader.dto.HystorytravelDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title> Read Hystory</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
<% HystorytravelDTO ht = (HystorytravelDTO) request.getAttribute("dto"); %>

<table class="full">
	<tr>
			<th>idtravel</th>
			<th>idcity</th>
			<th>date</th>
			<th>travelindex</th>
			<th>Actions</th>
	</tr>
		<tr>
			<td><a href=TruckServlet?mode=read&id=<%=ht.getId()%> >
			<%=ht.getIdtravel() %></a></td>
			<td><%=ht.getIdcity()%></td>
			<td><%=ht.getDate()%></td>
			<td><%=ht.getTravelindex() %> </td>
			
				<td><a class="edit" href=TruckServlet?mode=read&update=true&id=<%=ht.getId()%>></a>&nbsp;&nbsp;<!-- Blank fields -->
					<a class="delete" href=TruckServlet?mode=delete&id=<%=ht.getId()%>></a>	<!-- Icon links within themed actions  -->
				</td>
			
		</tr>
</table>


</div>
<%@ include file="/css/footer.jsp" %>
</body>
</html>