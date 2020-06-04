<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true" %>
<html>
<head>
<link href="css/salvatorestyle.css" rel="stylesheet">

<title>Login Sample Project</title>
</head> 
<body <% if( request.getParameterMap().containsKey("cred") && request.getParameter("cred").equals( "1") )
		{ %>onload='alert("Credenziali Errate.\nSi prega di riprovare.");' <% }  %>> <!-- Javascript function for checking if credentials are correct, otherwise the alert is displayed -->

		<form class="login" action="LoginServlet" method="post">

				<label for="user">Username: </label>
			
				<input type="text" id="user" name="username" placeholder="Insert username" required> <!-- Required attribute is for forcing user to insert text -->
		
				<label for="pass">Password: </label>
			
				 <input type="password" id="pass" name="password" placeholder="Insert password" required>
		
			<button type="submit" value="Login" name="pulsante">Login</button>
		</form>

	
</body>
</html>