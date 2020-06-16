package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.dao.TravelRepository;
import it.contrader.dto.TravelDTO;
import it.contrader.model.Truck;
import it.contrader.model.Travel;

@Service
public class TravelService extends AbstractService<Travel, TravelDTO> {

	@Autowired
	private TravelRepository repository;

	public Travel convertTravelDTO(TravelDTO travelDTO) {
		return converter.toEntity(travelDTO);
	}
	
	public  List<TravelDTO> getByTruck_id(long id){
		return converter.toDTOList(repository.findByTruck_id(id)); 
	}
	
	public List<TravelDTO> getAllByTruck(Truck truck){
		return converter.toDTOList(repository.findAllByTruck(truck));
	}
	
	
}
