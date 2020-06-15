package it.contrader.controller;


import java.sql.Date;
import java.time.LocalDateTime;

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
import it.contrader.dto.TravelDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.City;
import it.contrader.model.Passenger;
import it.contrader.model.Truck;
import it.contrader.model.User;
import it.contrader.service.CityService;
import it.contrader.service.HystorytravelService;
import it.contrader.service.PassengerService;
import it.contrader.service.TravelService;
import it.contrader.service.TruckService;
import it.contrader.utils.StringtoTime;



@Controller 
@RequestMapping("/travel")
public class TravelController {
		
	@Autowired
	private TravelService service;
	@Autowired
	//private CityService serviceC;
	//@Autowired
	private TruckService serviceT;
	// passenger
	//@Autowired
	//private PassengerService serviceP;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "travel/travels";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id ) {
		service.delete(id);
		setAll(request);
		return "travel/travels";
	}
	
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		
		request.getSession().setAttribute("list", service.getAll());
		//request.getSession().setAttribute("listC", serviceC.getAll());
		request.getSession().setAttribute("listT", serviceT.getAll());
		//request.getSession().setAttribute("listP", serviceP.getAll());
		return "travel/updatetravel";
	}

	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("nometeam") String nometeam,
		@RequestParam("descrizione") String descrizione , @RequestParam("numeroutenti") String numeroutenti	) {
		
		
		TravelDTO dto = new TravelDTO();
		dto.setId(id);
		dto.setNometeam(nometeam);
		dto.setDescrizione(descrizione);
		dto.setNumeroutenti(numeroutenti);
		service.update(dto);
		setAll(request);
		return "travel/travels";
	}
	
	//@RequestParam("nometeam") String nometeam,
	//@RequestParam("descrizione") String descrizione, 
	//@RequestParam("numeroutenti") String numeroutenti
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
		//	@RequestParam("citydeparture") City cd,
		//	@RequestParam("cityarrive") City ca,
		//	@RequestParam("timedeparture") String tm,
	//		@RequestParam("timearrival") String at,
			@RequestParam("date") String date,
			@RequestParam("truck") Truck truk
		//	@RequestParam("passenger") Passenger pass
			) {
	
	//	UserConverter userConverter = new UserConverter();
		//UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		//userDTO.getId();
		TravelDTO dto = new TravelDTO();
	//	dto.setUser(userConverter.toEntity(userDTO));
		/*
		 * 
		 * Date dates =Date.valueOf(date);
	    	dto.setDate(dates);
		 * 
		 * 
		 */
//		dto.setTimedeparture(StringtoTime.convert(tm));
		dto.setTruck(truk);
		Date dates = Date.valueOf(date);
		dto.setDate(dates);
	
//		dto.setTimearrival(StringtoTime.convert(at));
	//	dto.setCitydeparture(cd);
	//	dto.setCityarrive(ca);
	//	dto.setPassenger(pass);
		service.insert(dto);
		setAll(request);
		return "travel/travels";
		
	}
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "travel/readtravels";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	//	request.getSession().setAttribute("listC", serviceC.getAll());
		request.getSession().setAttribute("listT", serviceT.getAll());
	//	request.getSession().setAttribute("listP", serviceP.getAll());
	}
}


