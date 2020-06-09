package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TruckDTO;
import it.contrader.service.TruckService;

public class TravelController {
	private String pathFolder = "travel/";

	@Autowired
	private TruckService service;

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
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("citydeparture") String citydeparture,
			@RequestParam("timedeparture") String timedeparture,
			@RequestParam("cityarrival") String cityarrival,
			@RequestParam("")
			) {
		return "test";
	}


	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id,
			@RequestParam("howManyPeople") int howManyPeople,
			@RequestParam("licensePlate") String licensePlate,
			@RequestParam("peopleBooking") int peopleBooking) {

		TruckDTO dto = new TruckDTO();
		dto.setId(id);
		dto.setHowManyPeople(howManyPeople);
		dto.setLicensePlate(licensePlate);
		dto.setPeopleBooking(peopleBooking);
		service.update(dto);
		setAll(request);
		return "trucks";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("howManyPeople") int howManyPeople,
			@RequestParam("licensePlate") String licensePlate,
			@RequestParam("peopleBooking") int peopleBooking) {
		TruckDTO dto = new TruckDTO();
		dto.setHowManyPeople(howManyPeople);
		dto.setLicensePlate(licensePlate);
		dto.setPeopleBooking(peopleBooking);
		service.insert(dto);
		setAll(request);
		return "trucks";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtruck";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}
