package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.DriverConverter;
import it.contrader.dao.DriverRepository;
import it.contrader.dto.DriverDTO;
import it.contrader.model.Driver;

@Service
public class DriverService extends AbstractService<Driver, DriverDTO> {

	@Autowired
	private DriverConverter converter; 
	@Autowired 
	private DriverRepository repository;

	//public DriverDTO findByUsernameAndPassword(String username, String password) {
	//	return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	//}
 
}
