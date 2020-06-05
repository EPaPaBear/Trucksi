<% 
	String mode = request.getParameter("mode");
	String url_path = request.getServletPath();
	String confronto = "";
	if (url_path.contains("/")) {
	  String[] url_splitted = url_path.split("/");
	  
	  if(url_splitted.length>=3) confronto = url_splitted[1];
	  else confronto = "home";
	  
	} else {
	  throw new IllegalArgumentException("La stringa " + url_path + " non contiene virgole");
	}
 
%>

<div class="navbar">
  <a <% if(confronto.equals("home")) out.println("class=\"active\""); %> href="homeadmin.jsp">Home</a>
  <a <% if(confronto.equals("user")) out.println("class=\"active\""); %> href="UserServlet?mode=userlist">Users</a>
  <a <% if(confronto.equals("truck")) out.println("class=\"active\""); %> href="TruckServlet?mode=trucklist">Trucks</a>
  <a <% if(confronto.equals("hystorytravel")) out.println("class=\"active\""); %> href="HystorytravelServlet?mode=hystorytravellist">Hystorytravel</a>
  <a <% if(confronto.equals("city")) out.println("class=\"active\""); %> href="CityServlet?mode=citylist">Cities</a>
  <a <% if(confronto.equals("travel")) out.println("class=\"active\""); %> href="TravelServlet?mode=travellist">Travel</a>
 
  <a href="LogoutServlet" id="logout">Logout</a>
</div>