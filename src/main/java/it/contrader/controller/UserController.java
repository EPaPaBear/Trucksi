package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.model.User.Usertype;

import it.contrader.dto.UserDTO;
import it.contrader.dto.DriverDTO;
import it.contrader.dto.PassengerDTO;
import it.contrader.dto.TruckDTO;


import it.contrader.model.User.Usertype;
import it.contrader.service.DriverService;
import it.contrader.service.PassengerService;
import it.contrader.service.UserService;
import it.contrader.service.TruckService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private TruckService truckService;  

	@Autowired
	private PassengerService passengerService; 
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		request.getSession().setAttribute("user", userDTO);

		switch (userDTO.getUsertype()) {

		case ADMIN:
			return "homeadmin";
			
		case DRIVER:
			return "homedriver";
			
		case PASSENGER:
			return "homepassenger";

		case USER:
			return "index";

		default:
			return "index";
		}
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "users";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "users";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateuser";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {

		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		service.update(dto);
		setAll(request);
		return "users";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		service.insert(dto);
		setAll(request);
		return "users";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readuser";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
	
	@PostMapping("/singin") 
	public String singin(HttpServletRequest request,
			 @RequestParam(value = "username", required = true) String username,
			 @RequestParam(value = "password", required = true) String password,
			 @RequestParam(value = "usertype", required = true) Usertype usertype,
			 @RequestParam("nameD") String nameD,
			 @RequestParam("surnameD") String surnameD,
			 @RequestParam("phoneD") String phoneD,
			 @RequestParam("ageD") String ageDriver,
			 @RequestParam("driverLicense") String driverLicense,
			 @RequestParam("model") String model,
			 @RequestParam("driverLicense") String licensePlate,
			 @RequestParam("nameP") String nameP,
			 @RequestParam("surnameP") String surnameP,
			 @RequestParam("phoneP") String phoneP,
			 @RequestParam("ageP") String agePassenger  
			) {
		
		//Converto i valori che mi servono interi
		int ageD = (ageDriver!="") ? Integer.parseInt(ageDriver) : 0;
		int ageP = (agePassenger!="") ? Integer.parseInt(agePassenger) : 0; 
		
		//Come prima cosa mi creo un utente nel db
		UserDTO dto = new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		
		//Mi salvo il risultato della insert che mi ritorna un dto, cosi gli aggiorno l'id
		dto=service.insert(dto);
		//Long idNewUser = dto.getId(); 
		
		
		if(dto.getUsertype().equals(Usertype.DRIVER)) { 
			//Mi creo un oggetto driver
			DriverDTO driverDTO = new DriverDTO(); 
			driverDTO.setName(nameD);
			driverDTO.setSurname(surnameD);
			driverDTO.setDriverLicense(driverLicense);
			driverDTO.setPhone(phoneD);
			driverDTO.setAge(ageD);
			driverDTO.setUser(service.convertUserDTO(dto));  
			
			//Inserisco il driver nel db
			driverDTO = driverService.insert(driverDTO);  
			
			if(!licensePlate.equals("") && !model.equals("")) {//Se ho info sul truck,lo inserisco
				//Una volta creato il driver mi creo il Truck
				TruckDTO truckDTO = new TruckDTO();
				truckDTO.setLicensePlate(licensePlate);
				truckDTO.setModel(model);
				truckDTO.setDriver(driverService.convertDriverDTO(driverDTO));  
				
				truckService.insert(truckDTO);
			}
		}else if(dto.getUsertype().equals(Usertype.PASSENGER)) {  
			PassengerDTO passengerDTO = new PassengerDTO();
			passengerDTO.setName(nameP);
			passengerDTO.setSurname(surnameP);
			passengerDTO.setPhone(phoneP);
			passengerDTO.setAge(ageP);
			passengerDTO.setUser(service.convertUserDTO(dto));
			
			passengerService.insert(passengerDTO);
		}
		
 		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listU", service.getAll());
	}
}
