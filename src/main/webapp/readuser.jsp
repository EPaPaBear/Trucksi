<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<%@ include file="/css/header2.jsp"%>
<br>
<div class="main">
	<%
		UserDTO u = (UserDTO) request.getSession().getAttribute("dto");
	%>


	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Usertype</th>
			<% if(u.getUsertype().toString().equals("DRIVER")){ %>
				<th>Name</th>
				<th>Surname</th>
				<th>Phone</th>
				<th>Driver License</th>
				<th>Age</th>
			<% } %>
			
			<% if(u.getUsertype().toString().equals("PASSENGER")){ %>
				<th>Name</th>
				<th>Surname</th>
				<th>Phone</th>
				<th>Age</th>
			<% } %>
		</tr>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getUsername()%></td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getUsertype()%></td>
			<% if(u.getUsertype().toString().equals("DRIVER")){ %>
				<td><%=u.getDriver().getName() %></td>
				<td><%=u.getDriver().getSurname() %></td>
				<td><%=u.getDriver().getPhone() %></td>
				<td><%=u.getDriver().getDriverLicense() %></td>
				<td><%=u.getDriver().getAge() %></td>
			<% } %>
			
			<% if(u.getUsertype().toString().equals("PASSENGER")){ %>
				<td><%=u.getPassenger().getName() %></td>
				<td><%=u.getPassenger().getSurname() %></td>
				<td><%=u.getPassenger().getPhone() %></td>
				<td><%=u.getPassenger().getAge() %></td>
			<% } %>
		</tr>
	</table>

	<br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br>


</div>

<%@ include file="/css/footer2.jsp"%>
