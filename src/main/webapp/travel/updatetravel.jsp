<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TravelDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Team Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Travel</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
 </div>
<br>
<div class="main">

<%TravelDTO t = (TravelDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/team/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nteam">Travel Date</label>
    </div>
    <div class="col-75">
      <input type="text" id="nteam" name="nometeam" value=<%=t.getTraveldate()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="descr">Passenger</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="passenger" name="passenger" value=<%=t.getPassenger()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Truck</label>
    </div>
   		 <div class="col-75">
 			<input
			type="text" id="truck" name="truck" value=<%=t.getTruck()%>>
    	</div>
    	<input type="hidden" name="idt" value =<%=t.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>