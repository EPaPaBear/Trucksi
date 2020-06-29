package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Travel;
import it.contrader.model.Truck;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {

	public List<Travel> findByTruck_id(long id); 
	public List<Travel> findAllByTruck(Truck truck); 

}
