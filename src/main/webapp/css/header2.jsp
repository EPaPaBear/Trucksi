<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>
<body>

	<div class="header">SAMPLE Project</div>
	<% 
		String get_uri = request.getRequestURI();
		boolean stampa = true ;
		if(get_uri != "" && get_uri != null){
			if(get_uri.equals("/singin.jsp")) stampa = false;
		}
		
		if(stampa){ 
	%>
	
		<%@include file="/common-content/menu.jsp" %>
	
	<% } %>