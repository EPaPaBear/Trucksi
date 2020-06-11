package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DriverDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.DriverService;
import it.contrader.service.TruckService;

@Controller
@RequestMapping("/truck")
public class TruckController {
	private String pathFolder = "truck/";

	@Autowired
	private TruckService service;
	
	@Autowired
	private DriverService driverService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return pathFolder+"trucks";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "trucks";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetruck";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id,
			@RequestParam("licensePlate") String licensePlate) {

		TruckDTO dto = new TruckDTO();
		dto.setId(id);
		dto.setLicensePlate(licensePlate);
		service.update(dto);
		setAll(request);
		return "trucks";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("licensePlate") String licensePlate
			) {
		TruckDTO dto = new TruckDTO();
		dto.setLicensePlate(licensePlate);
		service.insert(dto);
		setAll(request);
		return "truck/trucks";
	}

	@GetMapping("/read") 
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtruck";
	}

	private void setAll(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user"); 
		System.out.println(userDTO);
		if(userDTO.getUsertype().equals(Usertype.ADMIN))  request.getSession().setAttribute("listT", service.getAll());
		else request.getSession().setAttribute("listT", service.getAllByDriver(userDTO.getDriver()));
	}
}
