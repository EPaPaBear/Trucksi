<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit city</title>
<link href="css/salvatorestyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">

<% CityDTO t = (CityDTO) request.getAttribute("dto"); %>


<form id="floatleft" action="CityServlet?mode=update&id=<%=t.getId()%>" method="post">

<div class="row">
    <div class="col-40">
      <label for="user">City name</label> 
    </div>
    <div class="col-60"> 
      <input type="text" id="cityname" name="cityname" placeholder="Insert city name" value=<%=t.getCityname()%> required>
    </div>
  </div>
  
  <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="/css/footer.jsp" %>	
</body>
</html>