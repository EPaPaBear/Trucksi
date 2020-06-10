package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PassengerConverter;
import it.contrader.dao.PassengerRepository;
import it.contrader.dto.PassengerDTO;
import it.contrader.model.Passenger;

@Service
public class PassengerService extends AbstractService<Passenger, PassengerDTO> {

	@Autowired
	private PassengerConverter converter;
	@Autowired 
	private PassengerRepository repository;

	//public PassengerDTO findByUsernameAndPassword(String username, String password) {
	//	return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	//}

}
