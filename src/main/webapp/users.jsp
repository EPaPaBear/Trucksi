<%@ page import="it.contrader.dto.UserDTO" import="java.util.*"%>
<%@include file="css/header2.jsp"%>
	
	<div class="main">
		<%
			List<UserDTO> list = (List<UserDTO>) request.getSession().getAttribute("listU");
		%>
		<br>

		<table>
			<tr>
				<th>Username</th>
				<th>Password</th>
				<th>Usertype</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (UserDTO u : list) {
			%>
			<tr>
				<td><a href="/user/read?id=<%=u.getId()%>"> <%=u.getUsername()%>
				</a></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getUsertype()%></td>
				<td><a href="/user/preupdate?id=<%=u.getId()%>">Edit</a></td> 
				<td><a href="/user/active?id=<%=u.getId()%>"> <%  
				
				if(u.isActive()) out.print("<img src=\"/image/ico_attivo.png\">"); else out.print("<img src=\"/image/ico_inattivo.png\">"); %></a></td>
			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/user/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Username</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="username"
						placeholder="inserisci username">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Password</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="password"
						placeholder="inserisci password">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Usertype</label>
				</div>
				<div class="col-75">
					<select id="userSelect" name="usertype" onchange="hideContent()" required>
 						<option disabled selected>SELECT USERTYPE</option>
						<option value="ADMIN" showclass="">ADMIN</option>
						<option value="USER" showclass="">USER</option> 
						<option value="DRIVER" showclass="hideDriver">DRIVER</option>
						<option value="PASSENGER" showclass="hidePassenger">PASSENGER</option>

					</select>
				</div>
				
				<div class="hideDriver">
					<div class="col-25">
						<label for="nameD">Name</label>
					</div>
					<div class="col-75">
						<input type="text" name="nameD" id="nameD" placeholder="Name">
					</div>
					
					<div class="col-25">
						<label for="surnameD">Surname</label>
					</div>
					<div class="col-75">
						<input type="text" name="surnameD" id="surnameD" placeholder="Surname">
					</div>
					<div class="col-25">
						<label for="phoneD">Phone</label>
					</div>
					<div class="col-75">
						<input type="text" name="phoneD" id="phoneD" placeholder="Phone">
					</div>
					
					<div class="col-25">
						<label for="driverLicense">Driver License</label>
					</div>
					<div class="col-75">
						<input type="text" name="driverLicense" id="driverLicense" placeholder="Driver License">
					</div>
					
					<div class="col-25">
						<label for="ageD">Age</label>
					</div>
					<div class="col-75">
						<input type="text" name="ageD" id="ageD" placeholder="Age">
					</div>
					
					<div class="col-25">
						<label for="model">Model</label>
					</div>
					<div class="col-75">
						<input type="text" name="model" id="model" placeholder="Model" onchange="checkTruck()"> 
					</div>
					
					<div class="col-25">
						<label for="licensePlate">License Plate</label>
					</div>
					<div class="col-75">
						<input type="text" name="licensePlate" id="licensePlate" placeholder="License Plate" onchange="checkTruck()">
					</div>
				</div>
		
		<div class="hidePassenger">
			<div class="col-25">
				<label for="nameP">Name</label>
			</div>
			<div class="col-75">
				<input type="text" name="nameP" id="nameP" placeholder="Name">
			</div>
			
			<div class="col-25">
				<label for="surnameP">Surname</label>
			</div>
			<div class="col-75">
				<input type="text" name="surnameP" id="surnameP" placeholder="Surname">
			</div>
			
			<div class="col-25">
				<label for="phoneP">Phone</label>
			</div>
			<div class="col-75">
				<input type="text" name="phoneP" id="phoneP" placeholder="Phone">
			</div>
			
			<div class="col-25">
				<label for="ageP">Age</label>
			</div>
			<div class="col-75">
				<input type="text" name="ageP" id="ageP" placeholder="Age">
			</div>
		</div>
			</div>
			<input type="hidden" value="users" name="whereTo">
			<button type="submit">Insert</button>
		</form>

	</div>
	
	<script>
	
		function checkTruck(){
			const modello = document.querySelector("#model").value;
			const licensePlate = document.querySelector("#licensePlate").value;
			
			if(modello != "" || licensePlate != ""){
				document.querySelector("#model").required = true
				document.querySelector("#licensePlate").required = true
			}else{
				document.querySelector("#model").required = false
				document.querySelector("#licensePlate").required = false
			}
		}
		
		function hideContent(){  
			const index = document.querySelector('#userSelect').selectedIndex;
			const classToShow = document.querySelector('#userSelect').options[index].getAttribute("showclass");
			//Rendo tutti i form specifici hide
			clear('hideDriver');
			clear('hidePassenger');
			//Show solo quello che mi interessa
			if(classToShow!=''){  
				document.querySelector('.'+classToShow).style = "display: block;"
				const inputs=document.querySelectorAll('.'+classToShow+' input');
				
				inputs.forEach(function(item){
					if(item.id != "model" && item.id != "licensePlate"){
						item.required = true;	
					}
				}); 
				
			}
		}
		
		function clear(className){
			document.querySelector('.'+className).style = "display: none;";
			const inputs=document.querySelectorAll('.'+className+' input');
			
			inputs.forEach(function(item,index){
				item.required = false;
			});
		}
		
	</script>
	
<%@ include file="/css/footer2.jsp"%>
