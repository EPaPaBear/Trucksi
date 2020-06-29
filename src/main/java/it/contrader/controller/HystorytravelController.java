package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.contrader.dao.HystorytravelRepository;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.PassengerDTO;
import it.contrader.model.Hystorytravel;
import it.contrader.service.HystorytravelService;

@RestController
@RequestMapping("/hystorytravel")
@CrossOrigin(origins = "http://localhost:4200")
public class HystorytravelController  extends AbstractController<HystorytravelDTO> {
	

	
}
