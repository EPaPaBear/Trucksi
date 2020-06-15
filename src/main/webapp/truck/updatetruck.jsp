<%@ page import="it.contrader.dto.TruckDTO" import="it.contrader.dto.DriverDTO"  import="it.contrader.dto.UserDTO" import="it.contrader.model.User.Usertype" import="java.util.*"%>
<%@ include file="/css/header2.jsp"%>

<%
TruckDTO t = (TruckDTO) request.getSession().getAttribute("dto");
List<DriverDTO> listD = (List<DriverDTO>) request.getSession().getAttribute("listD"); 

UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
Usertype usertype = (userDTO!=null) ? userDTO.getUsertype() : null;	

String printSelected = "";
String optionsD = "";
String showSelect = "style=\"display:none;\"";

if(usertype.equals(Usertype.ADMIN)){ 
	showSelect = "style=\"display:block;\"";
}

for (DriverDTO d : listD) {
	//Se sei driver ti scelgo in automatico
	if(t.getDriver().getId() == d.getId()) printSelected = "selected";  
	else printSelected = "";
	
	optionsD+="<option "+printSelected+" value=\""+d.getId()+"\">"+d.getName()+" "+d.getSurname()+"</option>";
}
%>

<form id="floatright" action="/truck/update" method="post"> 
			<div class="row">
				<div class="col-25">
					<label for="model">Model</label>
				</div>
				<div class="col-75">
					<input type="text" id="model" name="model" placeholder="Enter Model" value=<%=t.getModel()%> required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="truck">License Plate</label>
				</div>
				<div class="col-75">
					<input type="text" id="truck" name="licensePlate" placeholder="Enter License Plate" value=<%=t.getLicensePlate()%> required>
				</div>
			</div>
			
			<select name="driver" id="driverSelect" <%=showSelect %>  required>
				<%=optionsD %>
			</select>
			
			<input type="hidden" name="id" value =<%=t.getId() %>>
			<button type="submit">Edit</button>
		</form>

<br>
<%@ include file="/css/footer2.jsp"%>