package it.contrader.service;


import org.springframework.stereotype.Service;

import it.contrader.dto.PassengerDTO;
import it.contrader.model.Passenger;

@Service
public class PassengerService extends AbstractService<Passenger, PassengerDTO> {


	//public PassengerDTO findByUsernameAndPassword(String username, String password) {
	//	return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	//}

}
