<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<%@ include file="/css/header2.jsp" %>


<% UserDTO u = (UserDTO) request.getSession().getAttribute("dto");


String stampaDriver = (u.getUsertype().toString().equals("DRIVER")) ? "style=\"display:block\"" : "style=\"display:none\"";
String stampaPassenger = (u.getUsertype().toString().equals("PASSENGER")) ? "style=\"display:block\"" : "style=\"display:none\"";

String dName="";
String dSurname="";
String dPhone="";
String dDriverLicense="";
int dAge=0;
Long idDriver = 0L;

String pName="";
String pSurname=""; 
String pPhone=""; 
int pAge=0; 
Long idPassenger = 0L;

if(u.getUsertype().toString().equals("DRIVER")){
	dName=(u.getDriver().getName() != null) ? u.getDriver().getName() : "";
	dSurname=(u.getDriver().getSurname() != null) ? u.getDriver().getSurname() : "";
	dPhone=(u.getDriver().getPhone() != null) ? u.getDriver().getPhone() : "";
	dDriverLicense=(u.getDriver().getDriverLicense() != null) ? u.getDriver().getDriverLicense() : "";
	dAge=(u.getDriver().getAge() > 0) ? u.getDriver().getAge() : 0;
	idDriver=u.getDriver().getId();
	
}else if(u.getUsertype().toString().equals("PASSENGER")){
	pName=(u.getPassenger().getName() != null) ? u.getPassenger().getName() : "";
	pSurname=(u.getPassenger().getSurname() != null) ? u.getPassenger().getSurname() : "";
	pPhone=(u.getPassenger().getPhone() != null) ? u.getPassenger().getPhone() : "";
	pAge=(u.getPassenger().getAge() > 0) ? u.getPassenger().getAge() : 0;
	idPassenger=u.getPassenger().getId();
}

%>


<form id="floatleft" action="/user/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="username" value=<%=u.getUsername()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  
  <div class="row" style="display:none;"> 
    <div class="col-25">
      <label for="type">Usertype</label>
    </div>
   		 <div class="col-75" >
 			<select id="type" name="usertype">
  				<option value="ADMIN" <%if(u.getUsertype().toString().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
  				<option value="USER" <%if(u.getUsertype().toString().equals("USER")) {%>selected<%}%>>USER</option>
  				<option value="DRIVER" <%if(u.getUsertype().toString().equals("DRIVER")) {%>selected<%}%>>DRIVER</option>
  				<option value="PASSENGER" <%if(u.getUsertype().toString().equals("PASSENGER")) {%>selected<%}%>>PASSENGER</option>
			</select>
    	</div>
    	<input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
  
  
  <div class="row">
  	<div <%=stampaDriver%> >
		<div class="col-25">
			<label for="nameD">Name</label>
		</div>
		<div class="col-75">
			<input type="text" name="nameD" id="nameD" placeholder="Name" value="<% out.print(dName);%>">
		</div>
		
		<div class="col-25">
			<label for="surnameD">Surname</label>
		</div>
		<div class="col-75">
			<input type="text" name="surnameD" id="surnameD" placeholder="Surname" value="<% out.print(dSurname);%>">
		</div>
		<div class="col-25">
			<label for="phoneD">Phone</label>
		</div>
		<div class="col-75">
			<input type="text" name="phoneD" id="phoneD" placeholder="Phone" value="<% out.print(dPhone);%>">
		</div>
		
		<div class="col-25">
			<label for="driverLicense">Driver License</label>
		</div>
		<div class="col-75">
			<input type="text" name="driverLicense" id="driverLicense" placeholder="Driver License" value="<% out.print(dDriverLicense);%>">
		</div>
		
		<div class="col-25">
			<label for="ageD">Age</label>
		</div>
		<div class="col-75">
			<input type="text" name="ageD" id="ageD" placeholder="Age" value="<% out.print(dAge);%>">
		</div>
	</div>

   	<div <%=stampaPassenger%> >
		<div class="col-25">
			<label for="nameP">Name</label>
		</div>
		<div class="col-75">
			<input type="text" name="nameP" id="nameP" placeholder="Name" value="<% out.print(pName);%>">
		</div>
		
		<div class="col-25">
			<label for="surnameP">Surname</label>
		</div>
		<div class="col-75">
			<input type="text" name="surnameP" id="surnameP" placeholder="Surname" value="<% out.print(pSurname);%>">
		</div>
		
		<div class="col-25">
			<label for="phoneP">Phone</label>
		</div>
		<div class="col-75">
			<input type="text" name="phoneP" id="phoneP" placeholder="Phone" value="<% out.print(pPhone);%>">
		</div>
		
		<div class="col-25">
			<label for="ageP">Age</label>
		</div>
		<div class="col-75">
			<input type="text" name="ageP" id="ageP" placeholder="Age" value="<% out.print(pAge);%>">
		</div>
	</div>
  </div>
  <input type="hidden" name="idDriver" value =<%=idDriver %>>
  <input type="hidden" name="idPassenger" value =<%=idPassenger %>>
  <input type="hidden" name="id" value =<%=u.getId() %>>
  <button type="submit" >Edit</button>
</form>

<%@ include file="/css/footer2.jsp" %>	