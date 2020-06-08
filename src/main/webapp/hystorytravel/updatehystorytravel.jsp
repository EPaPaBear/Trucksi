<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.List"
	import="it.contrader.dto.HystorytravelDTO"
	import="it.contrader.dto.CityDTO"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<meta charset="ISO-8859-1">
<title>Update Hystory travel</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
<% HystorytravelDTO ht = (HystorytravelDTO) request.getAttribute("dto"); %>
<% List<CityDTO> ltcs = (List<CityDTO>) request.getAttribute("listC"); %>
<form id="floatleft" action="HystorytravelServlet?mode=update&id=<%= ht.getId() %>"
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
      <input type="text" id="travel" name="travel" placeholder="Insert id travel" value=<%=ht.getIdtravel()%> readonly>
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
	      <div class="col-40">
	      <label for="date">Date:</label>
	     </div>
	       <div class="col-60">
	       
			<% String date = ht.getDate();
			
			String[] tokens = date.split("-");
			
			String anno = tokens[0];
			String mese = tokens[1];
			String giorno = tokens[2];
			
			 date = mese + "/" + giorno + "/" + anno;
			
			%>
				<input type="text" id="datepicker" name="date" value="<%=date %>">
  					
				
			
	    </div>
	    
	    <div class="col-40">
	    	<label for="travelindex">Travel Index:</label>
	    </div>
	    <div class="col-60">
	    <input type="number" id="travelindex" name="travelindex" min="0" value="<%=ht.getTravelindex() %>">    	  
	    </div>
	</div>
  <button type="submit" >Edit</button>
</form>
</div>
</body>
</html>