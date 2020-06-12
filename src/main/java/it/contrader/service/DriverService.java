package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.DriverConverter;
import it.contrader.dao.DriverRepository;
import it.contrader.dto.DriverDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Driver;
import it.contrader.model.Truck;

@Service
public class DriverService extends AbstractService<Driver, DriverDTO> {

	@Autowired
	private DriverConverter converter; 
	@Autowired 
	private DriverRepository repository;
	
	public DriverDTO findByUser(UserDTO user) { 
		return converter.toDTO(repository.findByUser(user));    
	}
	
	
	public Driver convertDriverDTO(DriverDTO driverDTO) {
		return converter.toEntity(driverDTO);
	}
 
}
