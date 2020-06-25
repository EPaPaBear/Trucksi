package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.CityDTO; 


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
@RequestMapping("/city")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController extends AbstractController<CityDTO>{
	
}