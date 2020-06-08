<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.HystorytravelDTO"
	import="it.contrader.dto.CityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hystory travel</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
<% HystorytravelDTO ht = (HystorytravelDTO) request.getAttribute("dto"); %>
<% List<CityDTO> ltcs = (List<CityDTO>) request.getAttribute("listC"); %>
<form id="floatleft" action="HystorytravelServelt?mode=update&id=<%= ht.getId() %>"
method="post">
	<!--  <th>idtravel</th>
			<th>idcity</th>
			<th>date</th>
			<th>travelindex</th>  -->
<div class="row">
	<div class="col-40">
		<label for="idtravel">Id travel:</label>
	</div>
	  <div class="col-60"> 
      <input type="text" id="idtravel" name="idtravel" placeholder="Insert id travel" value=<%=ht.getIdtravel()%> readonly>
    </div>
</div>
	<div class="row">
	    <div class="col-40">
	      <label for="city">City:</label>
	     </div>
	     <div class="col-60">
			<select name="city" id="city">
				<%for (CityDTO ltc : ltcs) { %>
  					<option value="<%=ltc.getId()%>"><%=ltc.getCityname() %></option>
				<%}%>
			</select>
	    </div>
	</div>
  <button type="submit" >Edit</button>
</form>
</div>
</body>
</html>