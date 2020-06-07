<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.HystorytravelDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
<% HystorytravelDTO ht = (HystorytravelDTO) request.getAttribute("dto"); %>
<form id="floatleft" action="HystorytravelServelt?mode=update&id=<%= ht.getId() %>"
method="post">
<div class="row">
	<div class="col-40">
	<!--  <th>idtravel</th>
			<th>idcity</th>
			<th>date</th>
			<th>travelindex</th>  -->
		<label for="idtravel"> </label>
	</div>
	  <div class="col-60"> 
      <input type="text" id="idtravel" name="idtravel" placeholder="Insert id travel" value=%=ht.getIdtravel%> required>
    </div>
</div>
  <button type="submit" >Edit</button>
</form>
</div>
</body>
</html>