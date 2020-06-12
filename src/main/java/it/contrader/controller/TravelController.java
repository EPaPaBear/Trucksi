package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import it.contrader.dto.TravelDTO;
import it.contrader.model.City;
import it.contrader.model.Passenger;
import it.contrader.model.Truck;
import it.contrader.service.CityService;
import it.contrader.service.PassengerService;
import it.contrader.service.TravelService;
import it.contrader.service.TruckService;



@Controller
@RequestMapping("/travel")
public class TravelController {
	private String pathFolder = "/travel/";
	@Autowired
	private TruckService serviceT;
	

	@Autowired
	private CityService serviceC;
	
	
	@Autowired
	private PassengerService serviceP;

	@Autowired
	private TravelService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return pathFolder+"travels";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "travels";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetravel";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id,
			@RequestParam("traveldate") String traveldate,
			@RequestParam("passenger") Passenger passenger,
			@RequestParam("truck") Truck truck)
		{

		TravelDTO dto = new TravelDTO();
		dto.setId(id);
		dto.setTraveldate(LocalDateTime.parse(traveldate));
		dto.setPassenger(passenger);
		dto.setTruck(truck);
		service.update(dto);
		setAll(request);
		return "travels";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
		//	@RequestParam("traveldate") String traveldate,
			@RequestParam("passenger") Passenger passenger,
			@RequestParam("truck") Truck truck,
			@RequestParam("city") City city)
			
	 {
		TravelDTO dto = new TravelDTO();
		dto.setTraveldate(LocalDateTime.parse(traveldate));
		dto.setPassenger(passenger);
		dto.setTruck(truck);
		service.insert(dto);
		setAll(request);
		return "travel/travels";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtravel";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("listT", service.getAll());
		request.getSession().setAttribute("TruckList", serviceT.getAll());
		request.getSession().setAttribute("PassengerList", serviceP.getAll());
		request.getSession().setAttribute("CityList", serviceC.getAll());


		
	}
}
