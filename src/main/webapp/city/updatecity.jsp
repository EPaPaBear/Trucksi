<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CityDTO"%>

<%@ include file="/css/header2.jsp" %>
<br>
<div class="main">

<% CityDTO c = (CityDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/city/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cityname">City Name</label> 
    </div>
    <div class="col-75">
      <input type="text" id="cityname" name="cityname" value=<%=c.getCityname()%>>
    </div>
  </div>
 
  <input type="hidden" name="id" value="<%=c.getId()%>">
  <button type="submit" >Edit</button>
</form>

<br>
<%@ include file="/css/footer2.jsp" %>	
