<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.HystorytravelDTO"
    import="java.util.List"
    import="it.contrader.dto.UserDTO"
    import="it.contrader.dto.TravelDTO"
     import="it.contrader.dto.CityDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hystory travel</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<%@ include file="/common-content/menu.jsp" %>
<div class="main">
	<%
		List<HystorytravelDTO> list = (List<HystorytravelDTO>) request.getAttribute("list");
		UserDTO user = (UserDTO) session.getAttribute("user") ; 
		String user_type = user.getUsertype().toUpperCase(); 
		List<TravelDTO> lts = (List<TravelDTO>) request.getAttribute("listT");
	//	System.out.println(list);
	//	System.out.println(lts);	
		List<CityDTO> ltcs = (List<CityDTO>) request.getAttribute("listC");
		int travelindex = (int)request.getAttribute("travelIndex");
	
	%>
	<!--  
<script>
  	$( function() {
    	$( "#dialog" ).dialog();
  	} );
</script>
<div id="dialog" title="Basic dialog">
  <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div> -->
	<table <% if(!user_type.equals("ADMIN")) out.println("class=\"full\""); %>> 
		<tr>
			<th>idtravel</th>
			<th>idcity</th>
			<th>date</th>
			<th>travelindex</th>
			<% if(user_type.equals("ADMIN")){ %>
				<th>Actions</th>
			<% } %>
		</tr>
		<%
			for (HystorytravelDTO t : list) { 
		%>
		<tr>
			<td><a href=HystorytravelServlet?mode=read&id=<%=t.getId()%> >
			<%=t.getIdtravel() %></a></td>
			<td><%=t.getIdcity()%></td>
			<td><%=t.getDate()%></td>
			<td><%=t.getTravelindex() %> </td>
			<% if(user_type.equals("ADMIN")){ %>
				<td><a class="edit" href=HystorytravelServlet?mode=read&update=true&id=<%=t.getId()%>></a>&nbsp;&nbsp;<!-- Blank fields -->
					<a class="delete" href=HystorytravelServlet?mode=delete&id=<%=t.getId()%>></a>	<!-- Icon links within themed actions  -->
				</td>
			<% } %>
		</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="HystorytravelServlet?mode=insert" method="post">	  
	<div class="row">
	    <div class="col-40">
	      <label for="travel">travel:</label>
	         </div>
	     <div class="col-60">
			<select name="travel" id="travel">
				<%for (TravelDTO lt : lts) { %>
  					<option value="<%=lt.getId()%>"><%=lt.getId()%></option>
				<%}%>
			</select>
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
	
	
	  
	  <div class="row">
	    <div class="col-40">
	     <label for="date">Date:</label>
	    </div>
	    <div class="col-60">
		  <input type="text" id="datepicker" name="date">
	    </div>
	  </div>
	   <div class="row">
	    <div class="col-40">
	     <label for="date">TravelIndex:</label>
	    </div>
	    <div class="col-60">
		  <input type="text" id="datepicker" name="travelindex" value="<%=travelindex %>">
	    </div>
	  </div>
	  
	
	      <button type="submit" >Insert</button>
	</form>
	
	
</div>
</body>
</html>