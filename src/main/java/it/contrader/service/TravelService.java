package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TravelConverter;
import it.contrader.converter.TruckConverter;
import it.contrader.dao.TravelRepository;
import it.contrader.dto.TravelDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Travel;

@Service
public class TravelService extends AbstractService<Travel,TravelDTO> {
	@Autowired
	private TravelConverter travelConverter;
	
	@Autowired
	private TravelRepository repository;
	
	@Autowired
	private TruckConverter truckConverter;
	
	public  List<TravelDTO> getByTruck_id(long id){
		return travelConverter.toDTOList(repository.findByTruck_id(id));
	}
	
	public List<TravelDTO> getAllByTruck(TruckDTO truckDTO){
		return travelConverter.toDTOList(repository.findAllByTruck(truckConverter.toEntity(truckDTO)));
	}

}
