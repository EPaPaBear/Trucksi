package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.TruckDTO;
import it.contrader.service.TruckService;
import it.contrader.service.UserService;


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
@RequestMapping("/truck")
@CrossOrigin(origins = "http://localhost:4200")
public class TruckController extends AbstractController<TruckDTO>{
	@Autowired
	private TruckService truckService;
	
	@GetMapping("/getallbydriver")
	public Iterable<TruckDTO> getAllByDriver(long id) {
		return truckService.getByDriver_id(id);
	}
	
}