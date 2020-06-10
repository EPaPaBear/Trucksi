package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TruckConverter;
import it.contrader.dao.TruckRepository;
import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Truck;
import it.contrader.model.User;

@Service
public class TruckService extends AbstractService<Truck, TruckDTO> {

	@Autowired
	private TruckConverter converter;
	@Autowired
	private TruckRepository repository;

	public Truck convertTruckDTO(TruckDTO truckDTO) {
		return converter.toEntity(truckDTO);
		
	}

}
