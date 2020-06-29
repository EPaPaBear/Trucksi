package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.dao.DriverRepository;
import it.contrader.dto.DriverDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Driver;

@Service
public class DriverService extends AbstractService<Driver, DriverDTO> {

	@Autowired 
	private DriverRepository repository;
	
	public DriverDTO findByUser(UserDTO user) { 
		return converter.toDTO(repository.findByUser(user));    
	}
	
	
	public Driver convertDriverDTO(DriverDTO driverDTO) {
		return converter.toEntity(driverDTO);
	}
 
}
