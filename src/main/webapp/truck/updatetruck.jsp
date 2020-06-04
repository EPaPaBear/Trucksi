<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TruckDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>Edit Truck</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">

<% TruckDTO t = (TruckDTO) request.getAttribute("dto"); %>


<form id="floatleft" action="TruckServlet?mode=update&id=<%=t.getId()%>" method="post">

<div class="row">
    <div class="col-40">
      <label for="user">License Plate</label> 
    </div>
    <div class="col-60"> 
      <input type="text" id="licenseplate" name="licenseplate" placeholder="Insert License Plate" value=<%=t.getLicensePlate()%> required>
    </div>
  </div>
  
  <div class="row">
    <div class="col-40">
     <label for="pass">How Many People</label>
    </div>
    <div class="col-60">
      <input type="number" id="howmanypeople" name="howmanypeople" min="0" placeholder="Insert How Many People" value=<%=t.getHowManyPeople()%> required> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-40">
      <label for="type">People Booking</label>
    </div>
  	<div class="col-60">
		<input type="number" id="peoplebooking" name="peoplebooking" min="0" placeholder="Insert People Booking" value=<%=t.getPeopleBooking()%> required> 
   	</div>
  </div>
  
  <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>