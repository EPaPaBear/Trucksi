package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TruckDTO;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.TravelDTO;
import it.contrader.service.TravelService;


/**
 * 
 * Questa classe estende AbstractController con tipo {@link UserDTO}.
 * In aggiunta ai metodi di CRUD si implementa il metodo di  login.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/travel")
@CrossOrigin(origins = "http://localhost:4200")
public class TravelController extends AbstractController<TravelDTO>{
	
	@Autowired
	private TravelService travelService;
	/*
	@PostMapping(value = "/getallbytruck")
	public List<TravelDTO> getAllByTruck(@RequestBody TruckDTO truckDTO){
		return travelService.getAllByTruck(truckDTO);
		
	*/
	/*
	@GetMapping
	Iterable<TravelDTO> getall( ){
		return travelService.getAll();
	}
	*/
}
