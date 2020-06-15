<%@ page import="it.contrader.dto.TruckDTO" import="it.contrader.dto.TravelDTO"   import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>

<%
TravelDTO t = (TravelDTO) request.getSession().getAttribute("dto");
List<TruckDTO> listT = (List<TruckDTO>) request.getSession().getAttribute("listT"); 

%>

<form id="floatright" action="/travel/update" method="post">

<div class="row">
   <div class="col-75">
      <input type="text" id="date" name="date" value=<%=t.getDate()%>>
    </div>
 </div>
  
 
<div class="row">
	    <div class="col-25">
	      <label for="truck">Vehicle</label>
	     </div>
	     <div class="col-75">
			<select name="truck" id="truck" required>
			 <option value="">None</option>
				<%for (TruckDTO ltt : listT) { %>
  					<option value="<%=t.getId()%>" > <%=ltt.getModel() %></option>
				<%}%>
			</select>
	    </div>
</div>

  
<br>
<%@ include file="/css/footer2.jsp"%>