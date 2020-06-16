package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.TravelDTO;
import it.contrader.dto.UserDTO;
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
	@PostMapping(value = "/travel")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		return userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
	*/
}