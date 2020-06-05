<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TravelDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/salvatorestyle.css" rel="stylesheet">
<title>Edit Travel</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">

<% TravelDTO t = (TravelDTO) request.getAttribute("dto"); %>


<form id="floatleft" action="TruckServlet?mode=update&id=<%=t.getId()%>" method="post">

<div class="row">
    <div class="col-40">
      <label for="user">Username ID</label> 
    </div>
    <div class="col-60"> 
      <input type="text" id="idusename" name="idusername" placeholder="Insert Username ID" value=<%=t.getIdusername()%> required>
    </div>
  </div>
  
  <div class="row">
    <div class="col-40">
     <label for="pass">Truck ID</label>
    </div>
    <div class="col-60">
      <input type="number" id="idtruck" name="idtruck" min="0" placeholder="Insert Truck ID" value=<%=t.getIdtruck()%> required> 
    </div>
  </div>
  
  <div class="row">
    <div class="col-40">
      <label for="type"> City ID</label>
    </div>
  	<div class="col-60">
		<input type="number" id="idcity" name="idcity" min="0" placeholder="Insert City ID" value=<%=t.getIdcity()%> required> 
   	</div>
  </div>
  
  <div class="row">
    <div class="col-40">
      <label for="type">History ID</label>
    </div>
  	<div class="col-60">
		<input type="number" id="idhistory" name="idhistory" min="0" placeholder="Insert History ID" value=<%=t.getIdhistory()%> required> 
   	</div>
  </div>
  
  <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>