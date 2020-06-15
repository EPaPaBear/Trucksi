<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CityDTO"%>
<%@ include file="/css/header2.jsp"%>
	<br>

	<div class="main">
		<%
			CityDTO c = (CityDTO) request.getSession().getAttribute("dto"); 
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>City name</th> 
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getCityname()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="/css/footer2.jsp"%>
