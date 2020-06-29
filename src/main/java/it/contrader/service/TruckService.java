package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.dao.TruckRepository;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Driver;
import it.contrader.model.Truck;

@Service
public class TruckService extends AbstractService<Truck, TruckDTO> {

	@Autowired
	private TruckRepository repository;

	public Truck convertTruckDTO(TruckDTO truckDTO) {
		return converter.toEntity(truckDTO);
	}
	
	public  List<TruckDTO> getByDriver_id(long id){
		return converter.toDTOList(repository.findByDriver_id(id)); 
	}
	
	public List<TruckDTO> getAllByDriver(Driver driver){
		return converter.toDTOList(repository.findAllByDriver(driver));
	}
	
	
}
