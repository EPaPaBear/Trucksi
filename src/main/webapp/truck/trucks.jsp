<%@ page import="it.contrader.dto.TruckDTO" import="it.contrader.dto.DriverDTO"  import="it.contrader.dto.UserDTO" import="it.contrader.model.User.Usertype" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>
	
	
	<div class="main">
		<%
			List<TruckDTO> list = (List<TruckDTO>) request.getSession().getAttribute("listT"); 
			List<DriverDTO> listD = (List<DriverDTO>) request.getSession().getAttribute("listD"); 
			
			UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		 	Usertype usertype = (userDTO!=null) ? userDTO.getUsertype() : null;	

		 	String optionsD = "";
			String printSelected = "";
			String printDriverTable = "";
			String showSelect = "style=\"display:none;\""; 
			
			//Se sei admin ti faccio vedere la select
			if(usertype.equals(Usertype.ADMIN)){ 
				showSelect = "style=\"display:block;\"";
				optionsD+="<option disabled selected>SELECT DRIVER</option>";
				printDriverTable = "<th>Driver</th>";
			}
			
			for (DriverDTO d : listD) {
				//Se sei driver ti scelgo in automatico
				if(usertype.equals(Usertype.DRIVER) && userDTO.getDriver().getId() == d.getId()) printSelected = "selected";
				else printSelected = "";
				
				optionsD+="<option "+printSelected+" value=\""+d.getId()+"\">"+d.getName()+" "+d.getSurname()+"</option>";
			}
		%>

		<br>

		<table>
			<tr>
				<th>Model</th>
				<th>License Plate</th>
				<%=printDriverTable %>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TruckDTO t : list) {
			%>
			<tr>
				<td>
					 <%=t.getModel()%>  
				</td>
				<td><%=t.getLicensePlate()%></td>
				<% if(printDriverTable != ""){
					out.print("<td>"+t.getDriver().getName() +" "+t.getDriver().getSurname()+"</td>");
				 } %>
				<td><a href="/truck/preupdate?id=<%=t.getId()%>">Edit</a></td>
				<td><a href="/truck/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/truck/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="model">Model</label>
				</div>
				<div class="col-75">
					<input type="text" id="model" name="model" placeholder="Enter Model" required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="truck">License Plate</label>
				</div>
				<div class="col-75">
					<input type="text" id="truck" name="licensePlate" placeholder="Enter License Plate" required>
				</div>
			</div>
			
			<select name="driver" id="driverSelect" <%=showSelect %>  required>
				<%=optionsD %>
			</select>
		
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
<%@ include file="/css/footer2.jsp"%>