<%@include file="css/header2.jsp"%>

	<form action="/user/singin" method="post" class="singin" name="singin" novalidate>
		<h1>SING IN</h1>

		<label for="inputUser" class="sr-only">Username</label> 
		<input type="text" name="username" id="inputUser" class="form-control" placeholder="Username" required autofocus>
		
		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required> 
		
		<select name="usertype" onchange="hideContent()" id="userSelect" required>
			<option disabled selected>SELECT USERTYPE</option>
			<option value="DRIVER" showclass="hideDriver">DRIVER</option>
			<option value="PASSENGER" showclass="hidePassenger">PASSENGER</option> 
		</select>
		
		<div class="hideDriver">
			<label for="nameD">Name</label>
			<input type="text" name="nameD" id="nameD" placeholder="Name">
			
			<label for="surnameD">Surname</label>
			<input type="text" name="surnameD" id="surnameD" placeholder="Surname">
			
			<label for="phoneD">Phone</label>
			<input type="text" name="phoneD" id="phoneD" placeholder="Phone">
			
			<label for="driverLicense">Driver License</label>
			<input type="text" name="driverLicense" id="driverLicense" placeholder="Driver License">
			
			<label for="ageD">Age</label>
			<input type="text" name="ageD" id="ageD" placeholder="Age">
			
			<label for="licensePlate">License Plate</label>
			<input type="text" name="licensePlate" id="licensePlate" placeholder="License Plate">
		</div>
		
		<div class="hidePassenger">
			<label for="nameP">Name</label>
			<input type="text" name="nameP" id="nameP" placeholder="Name">
			
			<label for="surnameP">Surname</label>
			<input type="text" name="surnameP" id="surnameP" placeholder="Surname">
			
			<label for="phoneP">Phone</label>
			<input type="text" name="phoneP" id="phoneP" placeholder="Phone">
			
			<label for="ageP">Age</label>
			<input type="text" name="ageP" id="ageP" placeholder="Age">
		</div>
		
		
		<input type="hidden" name="richiesta" value="login">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sing In</button>
	</form>
	
	<script>
		function hideContent(){ 
			const index = document.querySelector('#userSelect').selectedIndex;
			const classToShow = document.querySelector('#userSelect').options[index].getAttribute("showclass");
			//Rendo tutti i form specifici hide
			clear('hideDriver');
			clear('hidePassenger');
			//Show solo quello che mi interessa
			document.querySelector('.'+classToShow).style = "display: block;"
			const inputs=document.querySelectorAll('.'+classToShow+' input');
			
			inputs.forEach(function(item){
				item.required = true;
			});
		}
		
		function clear(className){
			document.querySelector('.'+className).style = "display: none;";
			const inputs=document.querySelectorAll('.'+className+' input');
			
			inputs.forEach(function(item,index){
				item.required = false;
			});
		}
		
	</script>
	
<%@ include file="css/footer2.jsp"%>