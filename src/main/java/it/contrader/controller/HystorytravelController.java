package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.contrader.dao.HystorytravelRepository;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.PassengerDTO;
import it.contrader.service.HystorytravelService;

@RestController
@RequestMapping("/api/v1/hystorytravel")
public class HystorytravelController  extends AbstractController<HystorytravelDTO> {
	
	@Autowired
	private HystorytravelService htService;
	@GetMapping("/{id}")
	HystorytravelDTO getByID (@PathVariable Long id ){
		return htService.read(id);
	}
	@GetMapping
	Iterable<HystorytravelDTO> getall ( ){
		return htService.getAll();
	}
	
	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public HystorytravelDTO addHystorytravel(@RequestBody HystorytravelDTO htdto) {
	    //code
		htService.insert(htdto);
		return htdto;
	}
}
