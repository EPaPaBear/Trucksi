package it.contrader.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.CityConverter;
import it.contrader.converter.TruckConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dto.CityDTO;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.City;
import it.contrader.model.Truck;
import it.contrader.model.User;
import it.contrader.service.CityService;
import it.contrader.service.HystorytravelService;
import it.contrader.service.TruckService;
import it.contrader.utils.StringtoTime;



@Controller 
@RequestMapping("/hystorytravel")
public class HystorytravelController {
		
	@Autowired
	private HystorytravelService service;
	@Autowired
	private CityService serviceC;
	@Autowired
	private TruckService serviceT;
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("idt") Long idt ) {
		service.delete(idt);
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	/*
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("idt") Long idt) {
		request.getSession().setAttribute("dto", service.read(idt));
		return "updateteam";
	}
	*/
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("idt") Long idt, @RequestParam("nometeam") String nometeam,
		@RequestParam("descrizione") String descrizione , @RequestParam("numeroutenti") String numeroutenti	) {
		
		
		HystorytravelDTO dto = new HystorytravelDTO();
		dto.setIdt(idt);
		dto.setNometeam(nometeam);
		dto.setDescrizione(descrizione);
		dto.setNumeroutenti(numeroutenti);
		service.update(dto);
		setAll(request);
		return "hystorytravel/hystorytravels";
	}
	
	//@RequestParam("nometeam") String nometeam,
	//@RequestParam("descrizione") String descrizione, 
	//@RequestParam("numeroutenti") String numeroutenti
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("citydeparture") City cd,
			@RequestParam("cityarrive") City ca,
			@RequestParam("timedeparture") String tm,
			@RequestParam("timearrival") String at,
			@RequestParam("truck") Truck truk
			) {
	
		UserConverter userConverter = new UserConverter();
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		userDTO.getId();
		HystorytravelDTO dto = new HystorytravelDTO();
		dto.setUser(userConverter.toEntity(userDTO));
		dto.setTimedeparture(StringtoTime.convert(tm));
		dto.setTruck(truk);
		dto.setTimearrival(StringtoTime.convert(at));
		dto.setCitydeparture(cd);
		dto.setCityarrive(ca);
		service.insert(dto);
		setAll(request);
		return "hystorytravel/hystorytravels";
		
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("idt") Long idt) {
		request.getSession().setAttribute("dto", service.read(idt));
		return "hystorytravel/readhystorytravels";
	}
	
	private void setAll(HttpServletRequest request) {
		/*get all hystorytravel */
		request.getSession().setAttribute("listH", service.getAll());
		/*get all city */
		request.getSession().setAttribute("listC", serviceC.getAll());
		request.getSession().setAttribute("listT", serviceT.getAll());
	}
}


