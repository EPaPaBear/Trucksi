<%@ page  import="it.contrader.dto.UserDTO" import="it.contrader.model.User.Usertype" %> 

<% 
	//javax.servlet.forward.request_uri ritorna effettivamente l'url che noi visualizziamo
	String url_path = (String) request.getAttribute("javax.servlet.forward.request_uri");
	String confronto = "";
	if(url_path != "" && url_path != null){//Controllo che url_path non sia nullo
	
		if (url_path.contains("/")) {//Controllo che abbia un path con /, come dovrebbe essere
		  String[] url_splitted = url_path.split("/");//Divido la stringa per avere i singoli nomi
		  
		  
		  if(url_splitted.length>=3) confronto = url_splitted[1];//Se ne ha almeno 2, uno sarà vuoto
		  else confronto = "home";//Altrimenti siamo nella home
		  
		 //Quando fai il login il link rimane user/login/ che per me dovrebbe essere home non user
		  if(url_splitted.length>=3 && url_splitted[2].equals("login")) confronto = "home"; 
		  
		} else {
		  throw new IllegalArgumentException("La stringa " + url_path + " non contiene virgole");
		}
	}else{
		confronto="home";
	}
	
	UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
	//Se non ho fatto il login, o se mi è scaduta la sessione riporto l'utente al login
	Usertype usertype = null; 
	String username = "";
	String printName= "";
	if(userDTO == null) { 
		response.sendRedirect("/index.jsp"); //error   
	}else{
		usertype = userDTO.getUsertype();
		if(usertype.equals(Usertype.DRIVER)){
			printName = userDTO.getDriver().getName() +" "+userDTO.getDriver().getSurname(); 
		}else if(usertype.equals(Usertype.PASSENGER)){
			printName = userDTO.getPassenger().getName()+" "+userDTO.getPassenger().getSurname(); 
		}else{
			printName = usertype.toString(); 
 		}
	}
	
%>

<div class="navbar">
  <a <% if(confronto.equals("home")) out.println("class=\"active\""); %> href="/homeadmin.jsp">Home</a>
  
  <% if(usertype!= null && !usertype.equals(Usertype.DRIVER) && !usertype.equals(Usertype.PASSENGER)){  %>  
  	<a <% if(confronto.equals("user")) out.println("class=\"active\""); %> href="/user/getall">Users</a> 
  <% } %>
  
  <% if(usertype!= null && !usertype.equals(Usertype.PASSENGER)){  %>
  	<a <% if(confronto.equals("truck")) out.println("class=\"active\""); %> href="/truck/getall">Trucks</a>
  <% } %>
  <a <% if(confronto.equals("hystorytravel")) out.println("class=\"active\""); %> href="/hystorytravel/getall">Hystorytravel</a>
  <!--<a <% if(confronto.equals("city")) out.println("class=\"active\""); %> href="cities">Cities</a>-->
 <a <% if(confronto.equals("travel")) out.println("class=\"active\""); %> href="/travel/getall">Travel</a>
 <a id="username"><%=printName %></a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
